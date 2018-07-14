package org.yourorghere;

/**
 *
 * @author JUMAWAL_GaGaH
 */
import static java.lang.Math.cos;
import static java.lang.Math.sin;
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
static float deg2rad(double degree) {
        return (float) (degree * (22.0 / 7) / 180);
    }

    static float getX(double sudut, double jarijari) {
        return (float) (cos(deg2rad(sudut)) * jarijari);
    }

    static float getY(double sudut, double jarijari) {
        return (float) (sin(deg2rad(sudut)) * jarijari);
    }

    static void segiLima(GL gl, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, float x5, float y5, float x6, float y6, float z) {
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex3f(x1, y1, z);
        gl.glVertex3f(x2, y2, z);
        gl.glVertex3f(x3, y3, z);
        gl.glVertex3f(x4, y4, z);
        gl.glVertex3f(x5, y5, z);
        gl.glVertex3f(x6, y6, z);
        gl.glEnd();
    }

    static void segiEmpatKecil(GL gl, float x1, float y1, float x2, float y2, float zDepan, float zBelakang) {
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(x1, y1, zDepan);
        gl.glVertex3f(x2, y2, zDepan);
        gl.glVertex3f(x2, y2, zBelakang);
        gl.glVertex3f(x1, y1, zBelakang);
        gl.glEnd();
    }

    static void kipas_angin(GL gl, float diameterluar, float diameterdalam, float tinggigigi, float ketebalan, float banyakgigi) {
        float delta = (float) (360.0 / banyakgigi);
        float sudut = 0;
        float zdepan = (float) (1 * ketebalan);
        float zbelakang = -zdepan;
        for (int i = 0; i < banyakgigi; i++) {
            float sudut1 = (float) (sudut - 2 * delta);
            float sudut2 = (float) (sudut + 0.5 * delta);
            float x1 = getX(sudut1, diameterdalam);
            float y1 = getY(sudut1, diameterdalam);
            float x2 = getX(sudut2, diameterdalam);
            float y2 = getY(sudut2, diameterdalam);
            float x3 = getX(sudut2, diameterluar);
            float y3 = getY(sudut2, diameterluar);
            float x4 = getX(sudut, diameterluar + tinggigigi);
            float y4 = getY(sudut, diameterluar + tinggigigi);
            float x5 = getX(sudut1, diameterluar);
            float y5 = getY(sudut1, diameterluar);
            float x6 = getX(sudut1, diameterluar);
            float y6 = getY(sudut1, diameterluar);
            gl.glColor3f(0, 1, 0);
            segiLima(gl, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6, zdepan);
            segiLima(gl, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6, zbelakang);
            gl.glColor3f(0, 1, 0);
            segiEmpatKecil(gl, x3, y3, x4, y4, zdepan, zbelakang);
            segiEmpatKecil(gl, x5, y5, x4, y4, zdepan, zbelakang);
            segiEmpatKecil(gl, x1, y1, x2, y2, zdepan, zbelakang);
            sudut += delta;

        }
    }
    float angle = 0;
    float direction = 1.0f;

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

        gl.glPushMatrix();
        gl.glTranslatef(0.5f, 3.5f, -13.7f);
        gl.glRotatef(angle, 0f, 1f, 1f);
        kipas_angin(gl, 1.3f, 0.2f, 1f, 0f, 4);
//        angle += direction;
//        if (angle >= 45 || angle <= -45) {
//            direction = -direction;
//        }
        angle++;
        gl.glPopMatrix();
        
        //untuk tabung ke3
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, 3.6f, -15.5f);
        gl.glRotatef(5f, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(-angle, 0f, 1f, 0f);
        objek.tabung3(gl);
        angle += direction;
        if (angle >= 45 || angle <= -45) {
            direction = -direction;
        }
        gl.glPopMatrix();

        //untuk kotak baling baling atas
//        //untuk kotak baling baling bawah
//        gl.glPushMatrix();
//        gl.glTranslatef(0.9f, 2.5f, -13.7f);
//        gl.glRotatef(90f, 0.0f, 0.0f, 1.0f);
//        objek.kotakK1(gl);
//        gl.glPopMatrix();
//
//        //untuk kotak baling baling kanan
//        gl.glPushMatrix();
//        gl.glTranslatef(1.5f, 3.0f, -13.7f);
//        gl.glRotatef(0f, 0.0f, 0.0f, 1.0f);
//        objek.kotakK1(gl);
//        gl.glPopMatrix();
//
//        //untuk kotak baling baling kiri
//        gl.glPushMatrix();
//        gl.glTranslatef(-0.5f, 3.0f, -13.7f);
//        gl.glRotatef(0f, 0.0f, 0.0f, 1.0f);
//        objek.kotakK1(gl);
//        gl.glPopMatrix();
        //tombol nomer 0
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f, 0.3f, -13.0f);
        gl.glRotatef(5f, 1.0f, 0.0f, 0.0f);
        objek.tombol(gl);
        gl.glPopMatrix();

        //tombol nomer 1
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.3f, -13.0f);
        gl.glRotatef(5f, 1.0f, 0.0f, 0.0f);
        objek.tombol(gl);
        gl.glPopMatrix();

        //tombol nomer 2
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, 0.3f, -13.0f);
        gl.glRotatef(5f, 1.0f, 0.0f, 0.0f);
        objek.tombol(gl);
        gl.glPopMatrix();

        //tombol nomer 3
        gl.glPushMatrix();
        gl.glTranslatef(1.0f, 0.3f, -13.0f);
        gl.glRotatef(5f, 1.0f, 0.0f, 0.0f);
        objek.tombol(gl);
        gl.glPopMatrix();

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
