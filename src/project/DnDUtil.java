package project;

import java.awt.Container;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.JComponent;

public class DnDUtil implements DragGestureListener, DragSourceListener, DropTargetListener, Transferable {
    static final DataFlavor[] supportedFlavors = { null };

    static
    {
        try { 
            supportedFlavors[ 0 ] = new DataFlavor( DataFlavor.javaJVMLocalObjectMimeType );
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }

    Object object;

    // Transferable methods.
    public Object getTransferData( DataFlavor flavor ) {
        if ( flavor.isMimeTypeEqual( DataFlavor.javaJVMLocalObjectMimeType ) )
            return object;
        else
            return null;
    }
    public DataFlavor[] getTransferDataFlavors() {
        return supportedFlavors;
    }
    public boolean isDataFlavorSupported( DataFlavor flavor ) {
        return flavor.isMimeTypeEqual( DataFlavor.javaJVMLocalObjectMimeType );
    }

    // DragGestureListener method.
    public void dragGestureRecognized( DragGestureEvent ev ) {
        ev.startDrag( null, this, this );
    }

    // DragSourceListener methods.
    public void dragDropEnd( DragSourceDropEvent ev ) { }
    public void dragEnter( DragSourceDragEvent ev ) { }
    public void dragExit( DragSourceEvent ev ) { }
    public void dragOver( DragSourceDragEvent ev ) {
        object = ev.getSource();
    }
    public void dropActionChanged( DragSourceDragEvent ev ) { }

    // DropTargetListener methods.
    public void dragEnter( DropTargetDragEvent ev ) { }
    public void dragExit( DropTargetEvent ev ) { }
    public void dragOver( DropTargetDragEvent ev ) {
        dropTargetDrag( ev );
    }
    public void dropActionChanged( DropTargetDragEvent ev ) {
        dropTargetDrag( ev );
    }
    void dropTargetDrag( DropTargetDragEvent ev ) {
        ev.acceptDrag( ev.getDropAction() );
    }

    public void drop( DropTargetDropEvent ev ) {
        ev.acceptDrop( ev.getDropAction() );
        try {
        	Object target = ev.getSource();
            Object source = ev.getTransferable().getTransferData( supportedFlavors[ 0 ] );
            JComponent component = (JComponent) ( ( DragSourceContext ) source ).getComponent();
            Container oldContainer = component.getParent();
            Container container = ( Container ) ( ( DropTarget ) target ).getComponent();
            container.add( component );
            oldContainer.validate();
            oldContainer.repaint();
            container.validate();
            container.repaint();
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
        ev.dropComplete( true );
    }
}