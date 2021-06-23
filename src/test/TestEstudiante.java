
package test;

import dominio.Estudiante;
import java.util.Scanner;

public class TestEstudiante {
    static Scanner datos = new Scanner(System.in);
    public static void main(String[] args) {
        int nroHombres,ne;
        System.out.println("cuantos estudiantes desea ingresar");
        int n=datos.nextInt();
        Estudiante [] estudiantes = new Estudiante [n];
        llenaEstudiante(estudiantes);
        System.out.println("orden de los estudiantes");
        MayorMenor(estudiantes,n);
        nroHombres = porcentajegenero(estudiantes);
        System.out.println("el % de h por encima del promedio: "+porcentajePromedio(estudiantes, nroHombres, 'm'));
        System.out.println("el % de m por encima del promedio: "+porcentajePromedio(estudiantes, nroHombres, 'f'));
        ne = notaAlta(estudiantes);
        System.out.println("el estudiante con la nota alta es: "+estudiantes[ne].getNombre());
    }
    public static void llenaEstudiante(Estudiante est[]){
        String nombre;
        char sexo;
        double nota;
        for(int i=0;i<est.length;i++){
            datos.nextLine();
            System.out.println("estudiante no: "+(i+1));
            System.out.println("Nombre: ");
            nombre = datos.nextLine();
            System.out.println("sexo: <<m>><<f>>");
            sexo = datos.next().charAt(0);
            System.out.println("nota: ");
            nota = datos.nextDouble();
            datos.nextLine();
            est[i] = new Estudiante (nombre,sexo,nota);   
        }
    }
    public static int porcentajegenero(Estudiante est[]){
        int cuentahombres = 0,cuentamujeres = 0;
        double porc;
        for (int i=0;i<est.length;i++){
            if(est[i].getSexo()=='m'){
                cuentahombres++;
            }
        }
        cuentamujeres = est.length - cuentahombres;
        System.out.println("%H: "+(cuentahombres*100/est.length));
        System.out.println("%M: "+(cuentamujeres*100/est.length));
        porc = cuentahombres*100/ est.length;
        return cuentahombres; 
    }
    public static double porcentajePromedio(Estudiante est[], int homb,char sex){
        int mujer = est.length - homb;
        int cuenta = 0; 
        double promedio = 0,  porch, porcm;
        for (int i=0;i<est.length;i++){
            promedio+=est[i].getNota();
        } 
        promedio = promedio/est.length;
        for (int i=0;i<est.length;i++){
            if (est[i].getNota()>promedio && est[i].getSexo() == sex) {
                cuenta ++; 
            }
        }
        porch = homb*100/est.length;
        porcm = mujer*100/est.length;
        if (sex=='m'&& homb>0){
            porch = cuenta * porch/homb;
            return porch;
        } else  if (mujer>0) {
            porcm = cuenta *porcm/mujer;
            return porcm; 
        } else {
            return 0;
        }
    } 
    public static int notaAlta (Estudiante est[]){
        double mayor = 0;
        int indice = 0;
        for (int i=1;i<est.length;i++){
            if (est[i].getNota()>mayor){
                mayor = est[i].getNota();
                indice = i;
            }
        }
        return indice; 
    } 
    public static void mostrarListado(Estudiante est[], int not){
        for(int i=0;i<not;i++){
            System.out.println(est[i].toString());
        }
    }
    public static void MayorMenor(Estudiante est[], int not){ 
        for(int i=0;i<not;i++){
            for(int j=0;j<not-1;j++){
                if(est[j].getNota()<=est[j+1].getNota()){
                    Estudiante aux;
                    aux=est[j];
                    est[j]=est[j+1];
                    est[j+1]=aux;
                }
            }
        }
        System.out.println("mayor a menor");
        for(int i=0;i<not;i++){
            System.out.println(est[i]+"  ");
        }
        System.out.println("menor a mayor");
        for (int i=not-1;i>=0;i--){
            System.out.println(est[i]+"  ");
        }
        System.out.println("  ");
    }
}

