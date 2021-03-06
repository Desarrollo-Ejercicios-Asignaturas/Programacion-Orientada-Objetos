/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.Scanner;

public class Ejecutor {
    public static void main(String[] args) {
        // listado de variables para ingreso de datos por teclado
        Scanner entrada = new Scanner(System.in);
        String nombreEstudiante;
        double nota;
        String materia;
        Calificacion [] calificacionesEstudiante;
        int numerocalificaciones;
        
        // Ingreso de valores por teclado
        System.out.println("Ingrese el nombre del estudiante");
        nombreEstudiante = entrada.nextLine();
        System.out.println("Ingrese el número de calificaciones");
        numerocalificaciones = entrada.nextInt();
        
        entrada.nextLine();
        
        // con el numerocalificaciones se crea el objeto arreglo de
        // calificaciones tipo Calificacion
        calificacionesEstudiante = new Calificacion[numerocalificaciones];
        
        for (int i = 0; i < numerocalificaciones; i++) {
            System.out.printf("Ingrese nombre de materia %d\n", i+1);
            materia = entrada.nextLine();
            System.out.printf("Ingrese calificación %d\n", i+1);
            nota = entrada.nextDouble();
            entrada.nextLine();
            // con las variables nota y nombreEstudiante se procede
            // a crear un objeto de tipo Calificacion
            Calificacion cal = new Calificacion(nota, materia);
            
            // Se agrega el objeto calificacion creado al arreglo
            // calificacionesEstudiante
            calificacionesEstudiante[i] = cal;
            
        }
        
        // con el ingreso del nombre del estudiante y el ingreso del conjunto
        // de calificaciones; se procede a crear el objeto de tipo
        // LibretaCalificacion
        LibretaCalificacion libreta = new LibretaCalificacion(nombreEstudiante,
                calificacionesEstudiante);
        // Se llama a los métodos que realizan el calculo del
        // promedio y promedio cualitativo
        libreta.establecerPromedio();
        libreta.establecerPromedioCualitativo();
        
        
        String cadena = "Libreta de Calificaciones\n";
        cadena = String.format("%sNombre: %s\nCalificaciones:\n", cadena, 
                libreta.obtenerEstudiante());
        for (int i = 0; i < libreta.obtenerCalificaciones().length; i++) {
            cadena = String.format("%s\t\t%s [%.2f]\n", cadena, 
                    libreta.obtenerCalificaciones()[i].obtenerNombreMateria(),
                    libreta.obtenerCalificaciones()[i].obtenerNota());
        }
        cadena = String.format("%sPromedio calificaciones: %.2f\n"
                + "Promedio cuantitativo: %s\n",  
                cadena, libreta.obtenerPromedio(), 
                libreta.obtenerPromedioCualitativo());
        
        System.out.printf("\n%s\n", libreta);
        
    }
}
