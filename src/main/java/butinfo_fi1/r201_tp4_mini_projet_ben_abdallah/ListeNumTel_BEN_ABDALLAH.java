/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package butinfo_fi1.r201_tp4_mini_projet_ben_abdallah;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author but-info
 */
public class ListeNumTel_BEN_ABDALLAH implements ListeNumTel{
    private final ArrayList<NumTel> Listenum;
    
    public ListeNumTel_BEN_ABDALLAH(ArrayList<NumTel> Listenum){
        this.Listenum = new ArrayList<>(Listenum);
        }

        @Override
        public boolean ajouterFin(NumTel num) {
            for(NumTel n : Listenum){
                if(num.equals(n)){
                    return false;
                }       
            } 
        Listenum.add(num);
        return true;
        }
        
        
        @Override
        public boolean ajouterDebut(NumTel num) {
            for(NumTel n : Listenum){
                if(num.equals(n)){
                    return false;
                }       
            } 
        Listenum.addFirst(num);
        return true;
        }

        @Override
        public boolean ajouter(int index, NumTel num) {
            for(NumTel n: Listenum){
                if(n.equals(num)){
                    return false;
                }
            }
            if(index < 0 || index > Listenum.size()){
                throw new IndexOutOfBoundsException("Index invalide : " + index);
            }
            Listenum.add(index, num);
            return true;
        }

        @Override
        public NumTel premierNumero() {
            if(Listenum.isEmpty()){
                return null;
            }
            return this.Listenum.get(0);
        }

        @Override
        public NumTel numero(int index) {
            if(index < 0 || index >= Listenum.size()){
                 return null; 
            }
            return Listenum.get(index); 
        }

        @Override
        public boolean contientNumero(NumTel num) {
            for(NumTel x : Listenum){
                if(x.equals(num)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public int nbNumeros() {
            int count = 0; 
            for(NumTel x : Listenum){
                count++;               
            }
           return count;
        }
        
        
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < Listenum.size(); i++){
                sb.append(Listenum.get(i));
                if(i < Listenum.size() - 1){
                    sb.append(", ");
                }
            }
            return sb.toString();
        }

        @Override
        public Iterator iterator() {
            return Listenum.iterator();
        }

        @Override
        public boolean retirer(int num) {
            if(Listenum.size() <= 1){
                return false;
            }
            
            String numStr = String.valueOf(num);
            
            for(int i = 0; i < Listenum.size(); i++){
                if(Listenum.get(i).getNum().equals(numStr)){
                    Listenum.remove(i);
                    return true;
                }
            }
            return false;
        }
        
        public void add(NumTel n) {
            Listenum.add(n);
        }
    }   
    
    
