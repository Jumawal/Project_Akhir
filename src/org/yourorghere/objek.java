/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

/**
 *
 * @author JUMAWAL_GaGaH
 */
import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class objek {

    static void baling(GL gl) {
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 2.0f, 2.0f);
        gl.glVertex3f(-2f, 2.5f, -0.5f);
        gl.glVertex3f(-2f, 2.5f, 0.5f);
        gl.glVertex3f(0f, 2.5f, 0f);
        gl.glVertex3f(0f, 2.5f, 0f);
        gl.glVertex3f(2f, 2.5f, -0.5f);
        gl.glVertex3f(2f, 2.5f, 0.5f);
        gl.glEnd();
    }

    static void kotak2(GL gl) {
        gl.glBegin(GL.GL_POLYGON);/* f1: Surface bagian depan */
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f2: Surface bagian bawah
(ABFE) */
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f3:Surface bagian belakang
(CDHG)*/
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f4: Surface bagian atas
(EFGH)*/
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f5: Surface bagian kiri 
(ADEH)*/
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f6: Surface bagian kanan
(BCFG)*/
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();
    }

    static void Tabung(GL gl) {

        float amb[] = {1.34f, 0.34f, 0.34f, 1};
        float diff[] = {0.41f, 0.41f, 0.41f, 1};
        float spec[] = {0.11f, 0.11f, 0.11f, 1};
        float shine = 200;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,
                GL.GL_AMBIENT, amb, 1);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,
                GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,
                GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,
                GL.GL_SHININESS, shine);

        float BODY_LENGTH = 2.0f;
        float BODY_RADIUS = 0.5f;
        int SLICES = 30;
        int STACKS = 30;
        GLU glu = new GLU();
        GLUquadric q = glu.gluNewQuadric();

        glu.gluCylinder(q, BODY_RADIUS, BODY_RADIUS,
                BODY_LENGTH, SLICES, STACKS);
        glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, BODY_LENGTH);
        glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);
    }

    static void Tabung2(GL gl) {

        float amb[] = {1.34f, 0.34f, 0.34f, 1};
        float diff[] = {0.41f, 0.41f, 0.41f, 1};
        float spec[] = {0.11f, 0.11f, 0.11f, 1};
        float shine = 200;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,
                GL.GL_AMBIENT, amb, 1);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,
                GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,
                GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,
                GL.GL_SHININESS, shine);

        float BODY_LENGTH = 2.0f;
        float BODY_RADIUS = 0.4f;
        int SLICES = 30;
        int STACKS = 30;
        GLU glu = new GLU();
        GLUquadric q = glu.gluNewQuadric();

        glu.gluCylinder(q, BODY_RADIUS, BODY_RADIUS,
                BODY_LENGTH, SLICES, STACKS);
        glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, BODY_LENGTH);
        glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);
    }

    static void Bola(GL gl) {
        float BODY_RADIUS = 2.0f;
        int SLICES = 30;
        int STACKS = 30;
        GLU glu = new GLU();
        GLUquadric q = glu.gluNewQuadric();
        glu.gluSphere(q, BODY_RADIUS, SLICES, STACKS);
    }

    static void BigBox(GL gl) {
        float amb[] = {0, 0.5f, 0, 1};
        float diff[] = {0, 0.5f, 0, 1};
        float spec[] = {0, 0.5f, 0, 1};
        float shine = 0;
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, spec, 0);

        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

        gl.glBegin(GL.GL_QUADS);
        gl.glVertex3f(-10000, 0, -10000);
        gl.glVertex3f(10000, 0, -10000);
        gl.glVertex3f(10000, 0, 10000);
        gl.glVertex3f(-10000, 0, 10000);
        gl.glEnd();

    }

    static void kotak(GL gl) {
        gl.glBegin(GL.GL_POLYGON);/* f1: Surface bagian depan */
        gl.glColor3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 2.0f);
        gl.glVertex3f(2.0f, 0.0f, 2.0f);
        gl.glVertex3f(2.0f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f2: Surface bagian bawah
(ABFE) */
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(3.0f, 0.0f, 0.0f);
        gl.glVertex3f(3.0f, 3.0f, 0.0f);
        gl.glVertex3f(0.0f, 3.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f3:Surface bagian belakang
(CDHG)*/
        gl.glVertex3f(3.0f, 3.0f, 0.0f);
        gl.glVertex3f(3.0f, 3.0f, 3.0f);
        gl.glVertex3f(0.0f, 3.0f, 3.0f);
        gl.glVertex3f(0.0f, 3.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f4: Surface bagian atas
(EFGH)*/
        gl.glVertex3f(3.0f, 3.0f, 3.0f);
        gl.glVertex3f(3.0f, 0.0f, 3.0f);
        gl.glVertex3f(0.0f, 0.0f, 3.0f);
        gl.glVertex3f(0.0f, 3.0f, 3.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f5: Surface bagian kiri 
(ADEH)*/
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 3.0f, 0.0f);
        gl.glVertex3f(0.0f, 3.0f, 3.0f);
        gl.glVertex3f(0.0f, 0.0f, 3.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f6: Surface bagian kanan
(BCFG)*/
        gl.glVertex3f(3.0f, 0.0f, 0.0f);
        gl.glVertex3f(3.0f, 0.0f, 3.0f);
        gl.glVertex3f(3.0f, 3.0f, 3.0f);
        gl.glVertex3f(3.0f, 3.0f, 0.0f);
        gl.glEnd();
    }

    static void lingkaran(GL gl) {

    }
}
