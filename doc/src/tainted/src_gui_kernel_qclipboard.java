/*   Ported from: src.gui.kernel.qclipboard.cpp
<snip>
//! [0]
        QClipboard *clipboard = QApplication::clipboard();
        QString originalText = clipboard->text();
        ...
        clipboard->setText(newText);
//! [0]


//! [1]
        QMimeData *data = new QMimeData;
        data->setImageData(image);
        clipboard->setMimeData(data, mode);
//! [1]


</snip>
*/
import com.trolltech.qt.*;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import com.trolltech.qt.xml.*;
import com.trolltech.qt.network.*;
import com.trolltech.qt.sql.*;
import com.trolltech.qt.svg.*;


public class src_gui_kernel_qclipboard {
    public static void main(String args[]) {
        QApplication.initialize(args);
//! [0]
        QClipboard lipboard = QApplication.clipboard();
        StringsoriginalText = clipboard.text();
        ...
        clipboard.setText(newText);
//! [0]


//! [1]
        QMimeData ata = new QMimeData;
        data.setImageData(image);
        clipboard.setMimeData(data, mode);
//! [1]


    }
}