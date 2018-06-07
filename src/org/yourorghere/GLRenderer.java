package org.yourorghere;

/**
 *
 * @author JUMAWAL_GaGaH
 */
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class GLRenderer implements GLEventListener {
//class vector untuk memudah vektor-isasi

    private class vector {

        float x;
        float y;
        float z;

        public vector(float startX, float startY, float startZ) {
            x = startX;
            y = startY;
            z = startZ;
        }
    }
    vector lineal = new vector(0f, 0f, -1f);//deklarasi awal vektor untuk maju
    vector lineal2 = new vector(0f, 0f, 1f);//deklarasi awal vektor untuk maju
    vector lateral = new vector(-1f, 0f, 0f);//deklarasi awal vektor untuk gerakan ke kanan
    vector lateral2 = new vector(1f, 0f, 0f);//deklarasi awal vektor untuk gerakan ke kanan
    vector vertical = new vector(0f, 1f, 0f);//deklarasi awal vetor untuk gerakan naik
    vector vertical2 = new vector(0f, -1f, 0f);//deklarasi awal vetor untuk gerakan naik
    vector Sumbu_z = new vector(0f, 0f, -1f);//deklarasiawal vektor untuk maju & mundur 
    vector Sumbu_x = new vector(1f, 0f, 0f);//deklarasi awal vektor untuk gerakan ke kanan & kiri 
    vector Sumbu_y = new vector(0f, 1f, 0f);//deklarasi awal vetor untuk gerakan naik & turun

    float Cx = 0, Cy = 2.5f, Cz = 0;
    float Lx = 0, Ly = 2.5f, Lz = -20f;

    float sudut_x = 0f;
    float sudut_x2 = 0f;

    float sudut_z = 0f;
    float sudut_z2 = 0f;

    float sudut_y = 0f;
    float sudut_y2 = 0f;

    boolean ori = true;

    /*
     ini adalah metod untuk melakukan pergerakan.
     magnitude adalah besarnya gerakan sedangkan direction digunakan untuk menentukan arah.
     gunakan -1 untuk arah berlawanan dengan vektor awal
     */
    private void vectorMovement(vector toMove, float magnitude, float direction) {
        float speedX = toMove.x * magnitude * direction;
        float speedY = toMove.y * magnitude * direction;
        float speedZ = toMove.z * magnitude * direction;
        Cx += speedX;
        Cy += speedY;
        Cz += speedZ;
        Lx += speedX;
        Ly += speedY;
        Lz += speedZ;
    }
//    float Cx = 5f, Cy = 0f, Cz = 5f;
//    float Lx = 0f, Ly = 0f, Lz = -20f;

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: "
                + gl.getClass().getName());
        // Enable VSync
        gl.setSwapInterval(1);
        float ambient[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float position[] = {1.0f, 1.0f, 1.0f, 0.0f};
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT,
                ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE,
                diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION,
                position, 0);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glClearColor(1f, 1f, 1.0f, 1.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) { // avoid a divide by zero error!
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();

        glu.gluLookAt(Cx, Cy, Cz, Lx, Ly, Lz, Sumbu_y.x, Sumbu_y.y, Sumbu_y.z);

        //untuk kotak
        gl.glPushMatrix();
        gl.glTranslatef(-1f, 0.5f, -15f);
        gl.glRotatef(90f, 1f, 0, 0);
        objek.kotak(gl);
        gl.glPopMatrix();

        //untuk tabung pertama
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, 2f, -15f);
        gl.glRotatef(90f, 1f, 0, 0);
        objek.Tabung(gl);
        gl.glPopMatrix();

        //untuk tabung kedua
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, 4f, -15f);
        gl.glRotatef(90f, 1f, 0, 0);
        objek.Tabung2(gl);
        gl.glPopMatrix();

        //untuk kotak atas
        gl.glPushMatrix();
        gl.glTranslatef(0f, 4f, -15.2f);
        gl.glRotatef(90f, 1f, 0, 0);
        objek.kotak2(gl);
        gl.glPopMatrix();

//        //untuk baling baling
//        gl.glPushMatrix();
//        gl.glTranslatef(0.5f, 3.5f, -15.2f);
//        gl.glRotatef(90f, 1f, 0, 0);
//        objek.baling(gl);
//        gl.glPopMatrix();
        gl.glPushMatrix();
        objek.BigBox(gl);
        gl.glPopMatrix();

        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

    }

    void Key_Pressed(int keyCode) {
        //huruf S (huruf S <-> W)
        if (keyCode == 83) {
            vectorMovement(lineal, 2f, -1f);
        }//huruf W (huruf W <-> S)
        else if (keyCode == 87) {
            vectorMovement(lineal2, 2f, -1f);
        } //huruf D (huruf D <-> A)
        else if (keyCode == 65) {
            vectorMovement(lateral, 2f, -1f);
        } //huruf A (huruf A <-> D)
        else if (keyCode == 68) {
            vectorMovement(lateral2, 2f, -1f);
        } //panah atas
        else if (keyCode == 38) {
            vectorMovement(vertical, 2f, -1f);
        } //panah bawah
        else if (keyCode == 40) {
            vectorMovement(vertical2, 2f, -1f);
        }//panah  kanan
        else if (keyCode == 39) {
            vectorMovement(lateral2, 2f, -1f);
        } //panah kiri
        else if (keyCode == 37) {
            vectorMovement(lateral, 2f, -1f);
        } //huruf E
        else if (keyCode == 69) {
            Cx = 0f;
            Cy = 14f;
            Cz = 2f;
            Lx = 0f;
            Ly = 0f;
            Lz = 0f;
        } else {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.     
        }

    }

}
