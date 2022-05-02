package vidmot;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import vinnsla.Bingospjald;
import java.net.URL;
import java.util.ResourceBundle;
/******************************************************
 *   Nafn    : Hákon Ingi Rafnsson
 *   T-póstur: hir12@hi.is
 *
 *   Lýsing  : Viðmótsklasi sem að setur tölur inn í takkana á bingóspjaldinu og gefur þeim virkni.
 *             Þegar hakað er í réttu takkana þá lætur forritið vita að komið sé bingó.
 *
 ******************************************************/
public class BingoController implements Initializable {

  /**
   * Tilviksbreytur fyrir grid, label og spjaldið.
   */
  @FXML
  private GridPane fxGrid;
  @FXML
  private Label fxLabel;

  private Bingospjald spjald;

  /**
   * Fall sem að setur bingótölur inn í takkana í fxml skjalinu.
   * @param url staðsetning takka í fxml skjalinu.
   * @param resourceBundle heldur utan um það sem er í tökkunum.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    ObservableList<Node> allChildren = fxGrid.getChildren();
    spjald = new Bingospjald();
    int[][] rows = spjald.getSpjald();
    int index = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        Button b = (Button)allChildren.get(index);
        b.setText(String.valueOf(rows[i][j]));
        index++;
      }
    }
  }

  /**
   * Fall sem að inniheldur aðgerðir takkanna í bingóspjaldinu og birtir bingó þegar komið er bingó.
   * @param actionEvent tengist við takka og leyfir þeim að hafa aðgerðir eins og að verða rauðir þegar klikkað er á þá.
   */
  public void bingoHandler (ActionEvent actionEvent){
    Button b = (Button) actionEvent.getSource();
    b.setStyle("-fx-background-color: #FF0000");
    int i = GridPane.getRowIndex(b);
    Integer j = GridPane.getColumnIndex(b);
    if(j==null) j = 0;
    spjald.aReit(i-1, j);
    if (spjald.erBingo()) {
      fxLabel.setVisible(true);
    }
  }
}

