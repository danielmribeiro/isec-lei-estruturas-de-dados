package exercicio5;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int array1[]={3,3,4,2,4,4,2,4,4};
        int array2[]={3,3,4,2,4,4,2,4};
        System.out.println("N^2:    No array1 "+maioritarioN2(array1));
        System.out.println("N^2:    No array2 "+maioritarioN2(array2));
        System.out.println("N:      No array1 "+maioritarioN(array1));
        System.out.println("N:      No array2 "+maioritarioN(array2));
    }

    public static String maioritarioN2(int array[]){
        int N= array.length;
        int maxCount=0;
        int valorMaioritario=-1;
        int nIteracoes=0;
        for (int i = 0; i < N; i++) {
            int count=0;
            for (int j = 0; j < N; j++) {
                nIteracoes++;
                if(array[i]==array[j])
                    count++;
            }
            if(count > maxCount){
                maxCount=count;
                valorMaioritario=array[i];
            }
        }
        if(maxCount > N/2){
            return "##### O elemento maioritário é o "+valorMaioritario+ " e aparece em "+maxCount+" de "+N+" elementos ##### Numero de Iteracoes: " +nIteracoes;
        }else{
            return "##### Não há elemento maioritário ##### Numero de Iteracoes: " +nIteracoes;
        }
    }

    public static String maioritarioN(int array[]){
        int N=array.length;
        int nIteracoes=0;

        Map<Integer, Integer> hp = new HashMap<Integer, Integer>();

        //Inserir elementos no mapa
        for (int i = 0; i < N; i++) {
            int key = array[i];
            if(hp.containsKey(key)){
                int freq = hp.get(key);
                freq++;
                hp.put(key, freq);
            }else{
                hp.put(key,1);
            }
        }

        //encontrar o numero que se encontra em mais elementos
        int maxCount=0, valorMaioritario=-1;
        for(Map.Entry<Integer, Integer> val : hp.entrySet()){
            nIteracoes++;
            if(maxCount < val.getValue()){
                valorMaioritario = val.getKey();
                maxCount = val.getValue();
            }
        }

        if(maxCount > N/2){
            return "##### O elemento maioritário é o "+valorMaioritario+ " e aparece em "+maxCount+" de "+N+" elementos ##### Numero de Iteracoes: " +nIteracoes;
        }else{
            return "##### Não há elemento maioritário ##### Numero de Iteracoes: " +nIteracoes;
        }

    }
}
