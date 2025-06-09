package FuncoesDeHash;

public class FuncoesDeHash {
    // função de hash aceitável
    public static int hash1( String key, int tableSize ) { 
        int hashVal = 0; 
        for( int i = 0; i < key.length( ); i++ ){
            hashVal = ( hashVal * 128 + key.charAt( i ) ) % tableSize;
        } 
        return hashVal;
    }
    
    // função de hash aceitável –2ª versão
    public static int hash2( String key, int tableSize ) { 
        int hashVal = 0;
        for( int i = 0; i < key.length( ); i++ ){
            hashVal = ( hashVal * 128 + key.charAt( i ) );
        } 
        return hashVal % tableSize;
    }
    

    //função de hash –versão final
    public static int hash3( String key, int tableSize ) {
        int hashVal = 0;
        for( int i = 0; i < key.length( ); i++ ){
            hashVal = 37 * hashVal + key.charAt( i );
            hashVal %= tableSize;
            if( hashVal < 0 ){
                hashVal += tableSize;
            } 
            return hashVal;
        }
    }
    
    public static int hash4(String key, int tableSize) {
        int hashVal = 0;
        for( int i =0; i < key.length( ); i++ ){
            hashVal += key.charAt( i );
        } 
        return hashVal % tableSize;
    }
}


