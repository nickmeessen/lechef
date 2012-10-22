package local.lechef.views;

import local.lechef.models.ItemModel;
import local.mvc.Model;
import local.mvc.View;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ItemView extends JPanel implements View {

    private JLabel itemIcon;
    private JLabel itemLabel;

    public ItemView() {

        super(new FlowLayout(FlowLayout.LEFT));

        add(itemIcon = new JLabel());
        add(itemLabel = new JLabel());

        setBackground(Color.decode("#DDDDDD"));

        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.decode("#EDEDED"), 2), BorderFactory.createEtchedBorder()));

    }

    public void update(Model model) {

        ItemModel itemModel = (ItemModel) model;

        itemIcon.setIcon( itemModel.getIcon() );
        itemLabel.setText( "<html><b>&nbsp;" + itemModel.getLabel() + "</b></html>" );

        if (itemModel.getSelected()) {
            setBackground(Color.decode("#CCCCCC"));
        } else {
            setBackground(Color.decode("#DDDDDD"));
        }

    }
}
