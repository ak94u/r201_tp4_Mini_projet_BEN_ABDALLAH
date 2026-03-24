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
    private String num;
    private String type;
    
    public NumTel(String numero, String typeNum){
        this.num = numero;
        if(typeNum == null){
            this.type = "?";
        }else{
            this.type = typeNum;
        }
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNum() {
        return num;
    }

    public String getType() {
        return type;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.num);
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
        if (this.num == null ? other.num != null : !this.num.equals(other.num)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

   
    
    @Override
    public String toString(){
        return num + "( "+ type + ")";
    }

}
