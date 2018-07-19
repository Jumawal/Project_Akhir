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
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
        gl.glClearDepth(1.0f);
        gl.glEnable(gl.GL_DEPTH_TEST);
        gl.glDepthFunc(gl.GL_LEQUAL);
        gl.glShadeModel(gl.GL_SMOOTH);
        gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);
//        float ambient[] = {1.0f, 1.0f, 1.0f, 1.0f};
//        float diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
//        float position[] = {0.0f, 1.0f, 1.0f, 1.0f};
////        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT,
////                ambient, 0);
////        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE,
////                diffuse, 1);
//        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION,
//                position, 1);
//        gl.glEnable(GL.GL_LIGHT0);
//        gl.glEnable(GL.GL_LIGHTING);
//        gl.glEnable(GL.GL_DEPTH_TEST);
//        gl.glClearColor(1f, 1f, 1.0f, 1.0f);
//        //gl.glShadeModel(GL.GL_SMOOTH);
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

    float angle = 0;
    float direction = 2.0f;
    float angle2 = 0;
    boolean geleng = false;
    boolean no1 = false;
    boolean no2 = false;
    boolean no3 = false;
    boolean off = false;

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();

        glu.gluLookAt(Cx, Cy, Cz, Lx, Ly, Lz, Sumbu_y.x, Sumbu_y.y, Sumbu_y.z);

        //untuk kotak
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0.5f, -16f);
        gl.glRotatef(0f, 1f, 0, 0);
        objek.kotak(gl);
        gl.glPopMatrix();

        //untuk tabung pertama
        gl.glPushMatrix();
        gl.glTranslatef(0f, 3.0f, -15.8f);
        gl.glRotatef(90f, 1f, 0, 0);
        objek.Tabung(gl);
        gl.glPopMatrix();

        //untuk tabung kedua
        gl.glPushMatrix();
        gl.glTranslatef(0f, 5.0f, -15.8f);
        gl.glRotatef(90f, 1f, 0, 0);
        objek.Tabung2(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0f, 5.0f, -15.8f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        objek.Bola(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0f, 5.0f, -15.8f);
        gl.glRotatef(angle, 0f, 1f, 0f);
        objek.tabung3(gl);

        //baling-baling
        gl.glPushMatrix();
        gl.glRotatef(angle2, 0f, 0f, 1.0f);
        objek.kipas_angin(gl, 1f, 0f, 1f, 0.1f, 4f);
        gl.glPopMatrix();

        //tombol nomer 0
        gl.glPushMatrix();
        gl.glTranslatef(-1.5f, 0.8f, -14.5f);
        gl.glRotatef(5f, 1.0f, 0.0f, 0.0f);
        objek.tombol(gl);
        gl.glPopMatrix();

        //tombol nomer 1
        gl.glPushMatrix();
        gl.glTranslatef(-0.6f, 0.8f, -14.5f);
        gl.glRotatef(5f, 1.0f, 0.0f, 0.0f);
        objek.tombol(gl);
        gl.glPopMatrix();

        //tombol nomer 2
        gl.glPushMatrix();
        gl.glTranslatef(0.3f, 0.8f, -14.5f);
        gl.glRotatef(5f, 1.0f, 0.0f, 0.0f);
        objek.tombol(gl);
        gl.glPopMatrix();

        //tombol nomer 3
        gl.glPushMatrix();
        gl.glTranslatef(1.2f, 0.8f, -14.5f);
        gl.glRotatef(5f, 1.0f, 0.0f, 0.0f);
        objek.tombol(gl);
        gl.glPopMatrix();

        if (geleng) {
            angle += direction;
            if (angle >= 45 || angle <= -45) {
                direction = -direction;
            }
        }
        if (no1) {
            angle2 += 15f;
        }
        if (no2) {
            angle2 += 25f;
        }
        if (no3) {
            angle2 += 35f;
        }
        if (off) {
            angle2 += 0f;
        }

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
        } //tombol Spasi Muter setengah
        else if (keyCode == 32) {
            if (geleng) {
                geleng = false;
            } else {
                geleng = true;
            }
        } //tombol 1
        else if (keyCode == 49) {
            if (no1) {
                no1 = false;
            } else {
                no1 = true;
                no2 = false;
                no3 = false;
                off = false;
            }
        } //tombol 2
        else if (keyCode == 50) {
            if (no2) {
                no2 = false;
            } else {
                no2 = true;
                no1 = false;
                no3 = false;
                off = false;
            }
        } else if (keyCode == 51) {
            if (no3) {
                no3 = false;
            } else {
                no3 = true;
                no2 = false;
                no1 = false;
                off = false;
            }
        } else if (keyCode == 48) {
            if (off) {
                off = false;
            } else {
                off = false;
                no3 = false;
                no2 = false;
                no1 = false;
                geleng = false;
            }

        } else {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.     
        }

    }

}
