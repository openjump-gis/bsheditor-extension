package fr.michaelm.jump.bsheditor;

import com.vividsolutions.jump.workbench.plugin.Extension;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;
// 1.1.0 (2020-08-15) refactoring for i18n
// 1.0.0 (2020-10-04) migration to OpenJUMP 2
// 0.3.1 (2020-10-04) don't create a new editor if one already exists (#505)
// 0.3.0 (2020-06-12) 4 improvement sasked by János in support request #7
//       + upload of source code in the main repository
// 0.2.4 (2012-11-12) fix the plugin name in the menu
// 0.2.3 (2012-mm-jj)
// 0.2.1 (2009-12-20) add initial statements capability
// 0.2   (2009-03-20) makes the code java 5.0 compatible (M. Michaud)
// 0.1   (2004-11-13) initial release
public class BshEditorPlugInExtension extends Extension {

    public void configure(PlugInContext context) {
        new BeanShellEditorPlugIn().initialize(context);
    }

    public String getName() {return "BeanShell Script Editor";}

    public String getVersion() {return "0.3.1 (2020-10-04)";}

}
