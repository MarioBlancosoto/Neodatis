
package enoloxianeodatismongo;


public class Enoloxianeodatismongo {

   
    public static void main(String[] args) {
   Metodos metodos = new Metodos();
   
   metodos.conextar();
   //metodos.updatear();
   metodos.incrementarDatos();
   metodos.mostrarDatos();
   
   metodos.cerrar();
    }
    
}
