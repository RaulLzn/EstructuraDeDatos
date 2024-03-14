package raul.SGTTP;

import raul.SGTTP.Controller.SGTTPController;
import raul.SGTTP.Model.SGTTPModel;
import raul.SGTTP.View.SGTTPView;

public class SGTTP {

    public static void main(String[] args) {
        SGTTPController controller = new SGTTPController(new SGTTPModel(), new SGTTPView());
        controller.start();
    }
}
