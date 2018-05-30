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
    float Cx = 5f, Cy = 0f, Cz = 5f;
    float Lx = 0f, Ly = 0f, Lz = -20f;

    public void init(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        gl.setSwapInterval(1);

        gl.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
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
        glu.gluLookAt(Cx, Cy, Cz,
                Lx, Ly, Lz,
                0, 1, 0);
        gl.glPushMatrix();
        gl.glTranslatef(3f, -1f, -5f);
        gl.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        objek.Tabung(gl);
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
        } 
        else {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.     
        }

    }

}
