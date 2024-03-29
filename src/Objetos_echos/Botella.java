/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos_echos;

/**
 * atributos del objeto
 *
 * @author pomo6989
 */
public class Botella {

    private String material;//de que esta feta la botella
    private int capacitat;// capacitat de la botella maxima
    private String contenido;//tipo de contenido que tiene la botella
    private int caducitat;//data de caducitat
    private boolean oberta;//true si esta oberta
    private int liquid_actual;//liquit que conte la botella(els l que conte)

    //metodes propis botella
    //constructor(Por defecto dara estos parametros)
    public Botella(String material, int capacitat) {
        this.capacitat = capacitat; //hacemos que el usuario ponga la capacidat
        this.SetMaterial(material);//hacemos la validacion de el material
              //material_botella es la variable de el setter i material es la variable del constructor 
              //donde el usuario pondra el material i luego eso pasara 
              //a la variable material_botella i hara la validacion     
        this.oberta = false;//Cuando se cree el objeto este cerrada la botella
    }
    //--------------------------------------------
    //get -> Obtener(Mostrar)
    public String GetMaterial() {
        //return this.material   
        return material;
    }

    public int GetCaducitat() {
        return caducitat;
    }

    public int GetCapacitat() {
        return capacitat;
    }
    
    public boolean GetOberta() {
        return oberta;
    }
    
    //set -> Poner(poner las reglas)
    public void SetMaterial(String material_botella) {
        if (material_botella.equalsIgnoreCase("vidre")
                || material_botella.equalsIgnoreCase("plastico")) {//materials valids
            //material = material_botella
            this.material = material_botella;//this=el objeto llamado            
        } else {//si no es material valid
            System.out.println("El material " + material_botella + " no es valido" + "El material ahora es vidrio");
            this.material = "Vidrio";
        }
    }

    public void SetCapacitat(int caducitat) {
        //material = material_botella
        this.caducitat = caducitat;//this=el objeto llamado
    }

    public void SetContenido(int caducitat) {
        //material = material_botella
        this.caducitat = caducitat;//this=el objeto llamado
    }

    public void SetCaducitat(int caducitat) {
        if (caducitat >= 2023) {
            //material = material_botella
            this.caducitat = caducitat;//this=el objeto llamado
        } else {
            System.out.println("La fecha de caducidat tiene que ser mallor de 2023");
        }
    }

    public void SetOberta(boolean oberta) {
        this.oberta = oberta;
    }
}
