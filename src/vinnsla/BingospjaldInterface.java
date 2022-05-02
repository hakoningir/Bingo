package vinnsla;

/******************************************************
 *   Nafn    : Hákon Ingi Rafnsson
 *   T-póstur: hir12@hi.is
 *
 *   Lýsing  : Interface sem geymir stöðu spjaldsins. Hver reitur hefur heiltölu.
 *             Ef heiltalan er -1 þá er búið að haka í reitinn.
 *
 ******************************************************/
public interface BingospjaldInterface {
    /**
     * Talan á reit (i,j) hefur verið lesin upp. Reiturinn er merktur sem -1 í
     fylkinu.
     * Forskilyrði - (i,j) er innan marka bingóspjaldsins - óþarfi að tékka
     sérstaklega
     *
     * @param i er lárétt lína takkana.
     * @param j er lóðrétt lína takkana.
     */
    void aReit(int i, int j);
    /**
     * Frumstillir bingóspjald með tölum af handahófi
     *
     * @return skilar fylkinu með gögnum bingóspjaldsins
     */
    int[][] nyttSpjald();
    /**
     * Athugar hvort það er bingó í hornalínu spjaldsins
     *
     * @return true ef það er bingo annars false
     */
    boolean erBingo();
}
