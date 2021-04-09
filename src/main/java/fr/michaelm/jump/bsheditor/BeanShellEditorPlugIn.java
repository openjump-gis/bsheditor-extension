package fr.michaelm.jump.bsheditor;

import buoy.event.WindowClosingEvent;
import com.vividsolutions.jump.workbench.plugin.AbstractPlugIn;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;
import com.vividsolutions.jump.workbench.ui.MenuNames;
import java.util.Map;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import fr.michaelm.bsheditor.BeanShellEditor;

public class BeanShellEditorPlugIn extends AbstractPlugIn {
    
    public void initialize(PlugInContext context) {
        context.getFeatureInstaller()
                .addMainMenuPlugin(this,
                        new String[] { MenuNames.CUSTOMIZE },
                        getName() + "...",
                        false,
                        null,
                        null);
    }

    public String getName() {
        ResourceBundle i18n = ResourceBundle.getBundle(
                "BeanShellEditor_i18n",
                Locale.getDefault()
        );
        return i18n.getString("name");
    }

    // If an editor is already around, don't create a new one
    BeanShellEditor e= null;

    public boolean execute(PlugInContext context) {
        if (e == null) {
            System.out.println("e == null");
            Map<String,Object> map = new HashMap<>();
            map.put("wc", context.getWorkbenchContext());
            e = new BeanShellEditor(map, null);
            e.addEventLink(WindowClosingEvent.class, this, "exit");
            e.addInitStatement("import com.vividsolutions.jump.feature.*;");
            e.addInitStatement("import com.vividsolutions.jts.geom.*;");
            e.addInitStatement("import com.vividsolutions.jump.workbench.model.*;");
        } else {
            System.out.println("e != null");
        }
        e.setVisible(true);
        return true;
    }

    private void exit(){
        if (e != null) e.dispose();
        e = null;
    }
}
