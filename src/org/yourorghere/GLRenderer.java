/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
public class GLRenderer implements GLEventListener {
//class vector untuk memudah vektor-isasi
<<<<<<< HEAD

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
=======
    class vector {
    float x;
    float y;
    float z;
    public vector(float startX, float startY, float startZ){
    x = startX;
    y = startY;
    z = startZ;
    }
void vectorRotation(vector reference, float angle){
    vector temp = reference;
    float magnitude = (float)Math.sqrt(Math.pow(temp.x, 2)+Math.pow(temp.y, 2)+Math.pow(temp.z, 2));
    temp.x = temp.x/magnitude; temp.y = temp.y/magnitude; temp.z = temp.z/magnitude;
    float dot_product = (x*temp.x)+(y*temp.y)+(z*temp.z);
    float cross_product_x = (y*temp.z) - (temp.z*z);
    float cross_product_y = -((x*temp.z) - (z*temp.x));
    float cross_product_z = (x*temp.y) - (y*temp.x);
    float last_factor_rodrigues = (float) (1 - Math.cos(Math.toRadians(angle%360)));
    x = (float) ((x*Math.cos(Math.toRadians(angle%360)))
    +(cross_product_x*Math.sin(Math.toRadians(angle%360)))
    +(dot_product*last_factor_rodrigues*x));
    y = (float) ((this.y*Math.cos(Math.toRadians(angle%360)))
    +(cross_product_y*Math.sin(Math.toRadians(angle%360)))
    +(dot_product*last_factor_rodrigues*y));
    z = (float) ((z*Math.cos(Math.toRadians(angle%360)))
    +(cross_product_z*Math.sin(Math.toRadians(angle%360)))
    +(dot_product*last_factor_rodrigues*z));
    }
    }
    vector depanBelakang = new vector(0f, 0f, -1f);//deklarasi awal vektor untuk maju & mundur
    vector samping = new vector(1f, 0f, 0f);//deklarasi awal vektor untuk gerakan ke kanan & kiri
    vector vertikal = new vector(0f, 1f, 0f);//deklarasi awal vetor untuk gerakan naik & turun
        float Cx = 0, Cy = 2.5f, Cz = 0;
        float Lx = 0, Ly = 2.5f, Lz = -20f;
        float angle_depanBelakang = 0f;
        float angle_depanBelakang2 = 0f;
        float angle_samping = 0f;
        float angle_samping2 = 0f;
        float angle_vertikal = 0f;
        float angle_vertikal2 = 0f;
        float silinderAngle = 90f;
        float silinderAngle1 = 0f;
        float silinderAngle2 = 0f;
        boolean ori = true, silinder = false, kamera = false, kamera1 = false,kamera2 = false,kamera3 = false,kamera4 = false,kamera5 = false, silinder1 = false, silinder2 = false, silinder3 = false, silinder4 = false, silinder5 = false;
        /*
        ini adalah metod untuk melakukan pergerakan.
        magnitude adalah besarnya gerakan sedangkan direction digunakan untuk menentukan arah.
        gunakan -1 untuk arah berlawanan dengan vektor awal
        */
private void vectorMovement(vector toMove, float magnitude, float direction){
    float speedX = toMove.x*magnitude*direction;
    float speedY = toMove.y*magnitude*direction;
    float speedZ= toMove.z*magnitude*direction;
>>>>>>> 0bf5e716b58e4ca3a0beb56a583a7e00ce6eb998
        Cx += speedX;
        Cy += speedY;
        Cz += speedZ;
        Lx += speedX;
        Ly += speedY;
        Lz += speedZ;
    }
<<<<<<< HEAD
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
=======
private void cameraRotation(vector reference, double angle){
    float M = (float) (Math.sqrt(Math.pow(reference.x, 2)+ Math.pow(reference.y, 2) + Math.pow(reference.z, 2)));//magnitud
    float Up_x1 = reference.x/M; //melakukan
    float Up_y1 = reference.y/M; //normalisasi
    float Up_z1 = reference.z/M; //vektor patokan
    float VLx = Lx - Cx; float VLy = Ly - Cy; float VLz = Lz - Cz;
    float dot_product = (VLx*Up_x1)+(VLy*Up_y1)+(VLz*Up_z1);
    float cross_product_x = (Up_y1*VLz) - (VLy*Up_z1);
    float cross_product_y = -((Up_x1*VLz) - (Up_z1*VLx));
    float cross_product_z = (Up_x1*VLy) - (Up_y1*VLx);
    float last_factor_rodriques = (float) (1 - Math.cos(Math.toRadians(angle%360)));
    float Lx1 = (float) ((VLx*Math.cos(Math.toRadians(angle%360)))
    +(cross_product_x*Math.sin(Math.toRadians(angle%360)))
    +(dot_product*last_factor_rodriques*VLx));
    float Ly1 = (float) ((VLy*Math.cos(Math.toRadians(angle%360)))
    +(cross_product_y*Math.sin(Math.toRadians(angle%360)))
    +(dot_product*last_factor_rodriques*VLy));
    float Lz1 = (float) ((VLz*Math.cos(Math.toRadians(angle%360)))
    +(cross_product_z*Math.sin(Math.toRadians(angle%360)))
    +(dot_product*last_factor_rodriques*VLz));
        Lx = Lx1+Cx;
        Ly = Ly1+Cy;
        Lz = Lz1+Cz;
>>>>>>> 0bf5e716b58e4ca3a0beb56a583a7e00ce6eb998
    }
public void init(GLAutoDrawable drawable) {
// Use debug pipeline
// drawable.setGL(new DebugGL(drawable.getGL()));
    GL gl = drawable.getGL();
    System.err.println("INIT GL IS: " + gl.getClass().getName());
// Enable VSync
    gl.setSwapInterval(1);
    float ambient[] = {1.0f,1.0f,1.0f,1.0f };
    float diffuse[] = {1.0f,1.0f,1.0f,1.0f };
    float position[] = {1.0f,1.0f,1.0f,0.0f };
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, ambient,0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, diffuse,0);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position,0);
    gl.glEnable(GL.GL_LIGHT0);
    gl.glEnable(GL.GL_LIGHTING);
    gl.glEnable(GL.GL_DEPTH_TEST);
    gl.glClearColor(0f, 0f, 1.0f, 1.0f);
    gl.glShadeModel(GL.GL_SMOOTH);
    //gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }
<<<<<<< HEAD

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

=======
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
    // Clear the drawing area
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
    // Reset the current matrix to the "identity"
    gl.glLoadIdentity();
    // Move the "drawing cursor" around
    glu.gluLookAt(Cx, Cy, Cz,
    Lx, Ly, Lz,
    vertikal.x, vertikal.y, vertikal.z);
    gl.glPushMatrix();
    gl.glTranslatef(0f, 5f, -15f);
    gl.glRotatef(silinderAngle, 1f, 0, 0);
    gl.glRotatef(silinderAngle1, 0, 1f, 0);
    gl.glRotatef(silinderAngle2, 0, 0, 1f);
    objek.Tabung(gl);
    gl.glPopMatrix();
    gl.glPushMatrix();
    objek.BigBox(gl);
    gl.glPopMatrix();
    if(silinder)
        silinderAngle += 15f;
    if(silinder1)
        silinderAngle -=15f;
    if(silinder2)
        silinderAngle1 +=15f;
    if(silinder3)
        silinderAngle1 -=15f;
    if(silinder4)
        silinderAngle2 +=15f;
    if(silinder5)
        silinderAngle2 -=15f;
    if(kamera)
        Key_Pressed(74);
    if(kamera1)
        Key_Pressed(76);
    if(kamera2)
        Key_Pressed(73);
    if(kamera3)
        Key_Pressed(75);
    if(kamera4)
        Key_Pressed(39);
    if(kamera5)
        Key_Pressed(37);
    gl.glFlush();
>>>>>>> 0bf5e716b58e4ca3a0beb56a583a7e00ce6eb998
    }
public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
}
   void Key_Pressed(int keyCode) {
    //huruf W
    if(keyCode == 87){
    vectorMovement(depanBelakang, 2f, 1f);
    }
    //huruf S
    else if(keyCode == 83){
    vectorMovement(depanBelakang, 2f, -1f);
    }
    //huruf A
    else if(keyCode == 68){
    vectorMovement(samping, 2f, 1f);
    }
    //huruf D
    else if(keyCode == 65){
    vectorMovement(samping, 2f, -1f);
    }
    //panah atas
    else if(keyCode == 38){
    vectorMovement(vertikal, 2f, 1f);
    }
    //panah bawah
    else if(keyCode == 40){
    vectorMovement(vertikal, 2f, -1f);
    }
    //tombol spasi
    else if(keyCode == 32){
    if(silinder)
    silinder = false;
    else
    silinder = true;
    }
    //tombol1
    else if(keyCode == 49){
    if(silinder1)
    silinder1 = false;
    else
    silinder1 = true;
    }
    //tombol2
    else if(keyCode == 50){
    if(silinder2)
    silinder2 = false;
    else
    silinder2 = true;
    }
    //tombol3
    else if(keyCode == 51){
    if(silinder3)
    silinder3 = false;
    else
    silinder3 = true;
    }
    //tombol4
    else if(keyCode == 52){
    if(silinder4)
    silinder4 = false;
    else
    silinder4 = true;
    }
    //tombol3
    else if(keyCode == 53){
    if(silinder5)
    silinder5 = false;
    else
    silinder5 = true;
    }
    //tombol enter
    else if(keyCode == 10){
    if(kamera)
    kamera = false;
    else
    kamera = true;
    }
    //tombol z
    else if(keyCode == 90){
    if(kamera1)
    kamera1 = false;
    else
    kamera1 = true;
    }
    //tombol x
    else if(keyCode == 88){
    if(kamera2)
    kamera2 = false;
    else
    kamera2 = true;
    }
    //tombol c
    else if(keyCode == 67){
    if(kamera3)
    kamera3 = false;
    else
    kamera3 = true;
    }
    //tombol v
    else if(keyCode == 86){
    if(kamera4)
    kamera4 = false;
    else
    kamera4 = true;
    }
    //tombol b
    else if(keyCode == 66){
    if(kamera5)
    kamera5 = false;
    else
    kamera5 = true;
    }
    //huruf J
    else if(keyCode == 74){
    angle_vertikal += 15f;
    samping.vectorRotation(vertikal, angle_vertikal-angle_vertikal2);
    depanBelakang.vectorRotation(vertikal, angle_vertikal-angle_vertikal2);
    cameraRotation(vertikal, angle_vertikal-angle_vertikal2);
    angle_vertikal2 = angle_vertikal;
    }
    //huruf L
    else if(keyCode == 76){
    angle_vertikal -= 15f;
    samping.vectorRotation(vertikal, angle_vertikal-angle_vertikal2);
    depanBelakang.vectorRotation(vertikal, angle_vertikal-angle_vertikal2);
    cameraRotation(vertikal, angle_vertikal-angle_vertikal2);
    angle_vertikal2 = angle_vertikal;
    }
    //huruf I
    else if(keyCode == 73){
    angle_samping -= 15f;
    //vertikal.vectorRotation(samping, angle_samping-angle_samping2);
    depanBelakang.vectorRotation(samping, angle_samping-angle_samping2);
    cameraRotation(samping, angle_samping-angle_samping2);
    angle_samping2 = angle_samping;
    }
    //huruf K
    else if(keyCode == 75){
    angle_samping += 15f;
    //vertikal.vectorRotation(samping, angle_samping-angle_samping2);
    depanBelakang.vectorRotation(samping, angle_samping-angle_samping2);
    cameraRotation(samping, angle_samping-angle_samping2);
    angle_samping2 = angle_samping;
    }
    //panah kanan
    else if(keyCode == 39){
    angle_depanBelakang -= 15f;
    samping.vectorRotation(depanBelakang, angle_depanBelakang-angle_depanBelakang2);
    vertikal.vectorRotation(depanBelakang, angle_depanBelakang-angle_depanBelakang2);
    //cameraRotation(vertikal, angle_samping-angle_samping2);
    angle_depanBelakang2 = angle_depanBelakang;
    }
    //panah kiri
    else if(keyCode == 37){
    angle_depanBelakang += 15f;
    samping.vectorRotation(depanBelakang, angle_depanBelakang-angle_depanBelakang2);
    vertikal.vectorRotation(depanBelakang, angle_depanBelakang-angle_depanBelakang2);
    //cameraRotation(vertikal, angle_samping-angle_samping2);
    angle_depanBelakang2 = angle_depanBelakang;
    }
    }
    }
