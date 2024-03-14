package raul.SGTTP.Controller;

import raul.SGTTP.Model.SGTTPModel;
import raul.SGTTP.View.SGTTPView;

public class SGTTPController {
    private SGTTPModel model;
    private  SGTTPView view;

    public SGTTPController(SGTTPModel model, SGTTPView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        this.view.init(this.model.getTitle());
    }
}
