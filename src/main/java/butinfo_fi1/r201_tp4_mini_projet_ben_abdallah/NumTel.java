/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package butinfo_fi1.r201_tp4_mini_projet_ben_abdallah;

import java.util.Objects;
/**
 *
 * @author but-info
 */
public class NumTel {
    private int num;
    private String type;
    
    public NumTel(int numero, String typeNum){
        this.num = numero;
        if(type == null){
            this.type = "?";
        }else{
            this.type = typeNum;
        }
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public String getType() {
        return type;
    }
    
    public int HashCode(){
        return Objects.hash(this.num, this.type);
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.num;
        hash = 97 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NumTel other = (NumTel) obj;
        if (this.num != other.num) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

   
    
    @Override
    public String toString(){
        int n = getNum();
        String t = getType();
        return "numeros : " + n + " type: " + t;
    }
}
