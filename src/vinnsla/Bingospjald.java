package vinnsla;
import java.util.Random;
/******************************************************
 *   Nafn    : Hákon Ingi Rafnsson
 *   T-póstur: hir12@hi.is
 *
 *   Lýsing  : Vinnsluklasi sem að býr til heiltölur og setur þær í tvívítt fylki. Inniheldur einnig föll sem segja til
 *             hvort búið sé að haka í reit og hvort komið sé bingó.
 *
 ******************************************************/
public class Bingospjald implements BingospjaldInterface {
    /**
     * Tilviksbreyta sem að býr til tvívítt fylki sem að inniheldur bingótölur.
     */
    private final int[][] spjald;

    /**
     * Fall sem að býr til bingóspjaldið og setur tvívíðafylkið inn í það.
     */
    public Bingospjald() {
        spjald = nyttSpjald();
    }

    /**
     * Fall sem að setur staðsetningu talna sem hefur verið klikkað á sem -1.
     * @param i breyta fyrir láréttu röðina.
     * @param j breyta fyrir lóðrétty röðina.
     */
    public void aReit(int i, int j) {
        spjald[i][j] = -1;
    }

    /**
     * Fall sem að býr til tvívítt fylki, býr til slembitölur á milli 1 og 15, plúsar það með 15*i þar sem að i
     * finnur hvort talan eigi að vera á milli 1-15 í b-röð, 16-30 í i-röð o.s.frv.
     * @return skilar tvívíðu fylki sem inniheldur bingótölur.
     */
    public int[][] nyttSpjald(){
        int[][] rod = new int[5][5];
        Random random = new Random();
        int tala;
        for (int i = 0;i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tala = random.nextInt(15) + 15 * i;
                if (tala != rod[i][0] && tala != rod[i][1] && tala != rod[i][2] && tala != rod[i][3] && tala != rod[i][4]) {
                    rod[i][j] = tala;
                } else {
                    j--;
                }
            }
        }
        return rod;
    }

    /**
     * Fall sem að athugar hvort komið sé bingó.
     * @return skilar true eða false eftir hvort komið sé bingó eða ekki.
     */
    public boolean erBingo() {
        for (int i = 0; i < 5; i++) {
            if (spjald[i][i] != -1) {
                return false;
            }
        }
        return true;
    }

    public int[][] getSpjald() {
        return spjald;
    }
}
