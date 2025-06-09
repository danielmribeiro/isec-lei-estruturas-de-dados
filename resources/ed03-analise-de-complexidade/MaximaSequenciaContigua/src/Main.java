public class Main {

    public static void main(String[] args) {
        int[] conjunto1 = {2,3,4,-2,1}; //array de valores1
        int[] conjunto2 = {-2,1}; //array de valores2
        int[] conjunto3 = {-1,-2,-3}; //array de valores3
        int[] conjunto4 = {}; //array de valores4
        System.out.println("conjunto1 - V1:"+maxSeqContV1(conjunto1)+"\t V2:"+maxSeqContV2(conjunto1)+"\t V3a:"+maxSeqContV3a(conjunto1)+"\t V3a:"+maxSeqContV3b(conjunto1)+"\t V3c:"+maxSeqContV3c(conjunto1));
        System.out.println("conjunto2 - V1:"+maxSeqContV1(conjunto2)+"\t V2:"+maxSeqContV2(conjunto2)+"\t V3a:"+maxSeqContV3a(conjunto2)+"\t V3a:"+maxSeqContV3b(conjunto2)+"\t V3c:"+maxSeqContV3c(conjunto2));
        System.out.println("conjunto3 - V1:"+maxSeqContV1(conjunto3)+"\t V2:"+maxSeqContV2(conjunto3)+"\t V3a:"+maxSeqContV3a(conjunto3)+"\t V3a:"+maxSeqContV3b(conjunto3)+"\t V3c:"+maxSeqContV3c(conjunto3));
        System.out.println("conjunto4 - V1:"+maxSeqContV1(conjunto4)+"\t V2:"+maxSeqContV2(conjunto4)+"\t V3a:"+maxSeqContV3a(conjunto4)+"\t V3a:"+maxSeqContV3b(conjunto4)+"\t V3c:"+maxSeqContV3c(conjunto4));

    }

    private static String maxSeqContV1(int[] m) {
        int maxSoma=0;
        int N=m.length;
        int nIteracoes=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int estaSoma = 0;
                for (int k = i; k <= j; k++) {
                    nIteracoes++;
                    estaSoma+=m[k];
                }
                if(estaSoma>maxSoma){
                    maxSoma=estaSoma;
                }
            }
        }
        return "MaximaSequenciaContigua:"+maxSoma+" Iteracoes:"+nIteracoes;
    }

    private static String maxSeqContV2(int[] m) {
        int maxSoma=0;
        int N=m.length;
        int nIteracoes=0;
        for(int i=0; i<N; i++){
            int estaSoma=0;
            for(int j=i;j<N;j++){
                estaSoma+=m[j];
                nIteracoes++;
                if(estaSoma>maxSoma){
                    maxSoma=estaSoma;
                }
            }
        }
        return "MaximaSequenciaContigua:"+maxSoma+" Iteracoes:"+nIteracoes;
    }

    private static String maxSeqContV3a(int[] m) {
        int maxSoma=0;
        int N=m.length;
        int nIteracoes=0;
        for(int i=0; i<N; i++){
            int estaSoma=0;
            for(int j=i;j<N;j++){
                estaSoma+=m[j];
                nIteracoes++;
                if(estaSoma<0){
                    break;
                }
                if(estaSoma>maxSoma){
                    maxSoma=estaSoma;
                }
            }
        }
        return "MaximaSequenciaContigua:"+maxSoma+" Iteracoes:"+nIteracoes;
    }

    private static String maxSeqContV3b(int[] m) {
        int maxSoma=0;
        int N=m.length;
        int nIteracoes=0;
        for(int i=0; i<N; i++){
            int estaSoma=0;
            for(int j=i;j<N;j++){
                estaSoma+=m[j];
                nIteracoes++;
                if(estaSoma<0){
                    i=j;
                    break;
                }
                if(estaSoma>maxSoma){
                    maxSoma=estaSoma;
                }
            }
        }
        return "MaximaSequenciaContigua:"+maxSoma+" Iteracoes:"+nIteracoes;
    }

    private static String maxSeqContV3c(int[] m) {
        int maxSoma=0;
        int N=m.length;
        int nIteracoes=0;
        int estaSoma=0;
        for(int i=0; i<N; i++){
            estaSoma+=m[i];
            nIteracoes++;
            if(estaSoma>maxSoma){
                maxSoma=estaSoma;
            }
            if(estaSoma<0){
                estaSoma=0;
            }
        }
        return "MaximaSequenciaContigua:"+maxSoma+" Iteracoes:"+nIteracoes;
    }

}
