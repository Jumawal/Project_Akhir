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
import static java.lang.Math.cos;
import static java.lang.Math.sin;
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
        gl.glColor3f(0.0f, 1.0f, 0.0f);
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

        gl.glColor3f(0.0f, 1.0f, 1.0f);
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

        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(-10000, 0, -10000);
        gl.glVertex3f(10000, 0, -10000);
        gl.glVertex3f(10000, 0, 10000);
        gl.glVertex3f(-10000, 0, 10000);
        gl.glEnd();

    }

    static void kotak(GL gl) {
        gl.glBegin(GL.GL_POLYGON);/* f1: Surface bagian depan */
        gl.glColor3f(0.0f, 0.0f, 1.0f);
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

    static void tabung3(GL gl) {
//        float amb[] = {1.34f, 0.34f, 0.34f, 1};
//        float diff[] = {0.41f, 0.41f, 0.41f, 1};
//        float spec[] = {0.11f, 0.11f, 0.11f, 1};
//        float shine = 200;
//        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,
//                GL.GL_AMBIENT, amb, 1);
//        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,
//                GL.GL_DIFFUSE, diff, 0);
//        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,
//                GL.GL_SPECULAR, spec, 0);
//        gl.glMaterialf(GL.GL_FRONT_AND_BACK,
//                GL.GL_SHININESS, shine);

        gl.glColor3f(0.0f, 0.0f, 1.0f);
        float BODY_LENGTH = 1.5f;
        float BODY_RADIUS = 0.3f;
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

    static void kotakK1(GL gl) {
        gl.glBegin(GL.GL_POLYGON);/* f1: Surface bagian depan */
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.9f, 0.8f, 0.0f);
        gl.glVertex3f(0.9f, -0.0f, 0.0f);
        gl.glVertex3f(-0.9f, -0.0f, 0.0f);
        gl.glVertex3f(-0.9f, 0.8f, 0.0f);
        gl.glEnd();
    }

    static void tombol(GL gl) {
        gl.glBegin(GL.GL_POLYGON);/* f1: Surface bagian depan */
        gl.glColor3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.4f);
        gl.glVertex3f(0.4f, 0.0f, 0.4f);
        gl.glVertex3f(0.4f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f2: Surface bagian bawah
(ABFE) */
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.4f, 0.0f, 0.0f);
        gl.glVertex3f(0.4f, 0.4f, 0.0f);
        gl.glVertex3f(0.0f, 0.4f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f3:Surface bagian belakang
(CDHG)*/
        gl.glVertex3f(0.4f, 0.4f, 0.0f);
        gl.glVertex3f(0.4f, 0.4f, 0.4f);
        gl.glVertex3f(0.0f, 0.4f, 0.4f);
        gl.glVertex3f(0.0f, 0.4f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f4: Surface bagian atas
(EFGH)*/
        gl.glVertex3f(0.4f, 0.4f, 0.4f);
        gl.glVertex3f(0.4f, 0.0f, 0.4f);
        gl.glVertex3f(0.0f, 0.0f, 0.4f);
        gl.glVertex3f(0.0f, 0.4f, 0.4f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f5: Surface bagian kiri 
(ADEH)*/
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.4f, 0.0f);
        gl.glVertex3f(0.0f, 0.4f, 0.4f);
        gl.glVertex3f(0.0f, 0.0f, 0.4f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f6: Surface bagian kanan
(BCFG)*/
        gl.glVertex3f(0.4f, 0.0f, 0.0f);
        gl.glVertex3f(0.4f, 0.0f, 0.4f);
        gl.glVertex3f(0.4f, 0.4f, 0.4f);
        gl.glVertex3f(0.4f, 0.4f, 0.0f);
        gl.glEnd();

    }

    static void tombol2(GL gl) {
        gl.glBegin(GL.GL_POLYGON);/* f1: Surface bagian depan */
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.4f);
        gl.glVertex3f(0.4f, 0.0f, 0.4f);
        gl.glVertex3f(0.4f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f2: Surface bagian bawah
(ABFE) */
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.4f, 0.0f, 0.0f);
        gl.glVertex3f(0.4f, 0.4f, 0.0f);
        gl.glVertex3f(0.0f, 0.4f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f3:Surface bagian belakang
(CDHG)*/
        gl.glVertex3f(0.4f, 0.4f, 0.0f);
        gl.glVertex3f(0.4f, 0.4f, 0.4f);
        gl.glVertex3f(0.0f, 0.4f, 0.4f);
        gl.glVertex3f(0.0f, 0.4f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f4: Surface bagian atas
(EFGH)*/
        gl.glVertex3f(0.4f, 0.4f, 0.4f);
        gl.glVertex3f(0.4f, 0.0f, 0.4f);
        gl.glVertex3f(0.0f, 0.0f, 0.4f);
        gl.glVertex3f(0.0f, 0.4f, 0.4f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f5: Surface bagian kiri 
(ADEH)*/
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.4f, 0.0f);
        gl.glVertex3f(0.0f, 0.4f, 0.4f);
        gl.glVertex3f(0.0f, 0.0f, 0.4f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f6: Surface bagian kanan
(BCFG)*/
        gl.glVertex3f(0.4f, 0.0f, 0.0f);
        gl.glVertex3f(0.4f, 0.0f, 0.4f);
        gl.glVertex3f(0.4f, 0.4f, 0.4f);
        gl.glVertex3f(0.4f, 0.4f, 0.0f);
        gl.glEnd();

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
}