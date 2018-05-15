package Library.ui;

import com.example.jofy.common.MyClass;


import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.general.ann.RegisterOnStartup;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.IBAction;
import org.moe.natj.objc.ann.IBOutlet;
import org.moe.natj.objc.ann.ObjCClassName;
import org.moe.natj.objc.ann.Property;
import org.moe.natj.objc.ann.Selector;

import com.example.jofy.common.SearchAdapter;

import apple.uikit.UIButton;
import apple.uikit.UILabel;
import apple.uikit.UITextField;
import apple.uikit.UIViewController;
import apple.uikit.protocol.UITextFieldDelegate;


@org.moe.natj.general.ann.Runtime(ObjCRuntime.class)
@ObjCClassName("AppViewController")
@RegisterOnStartup
public class AppViewController extends UIViewController implements UITextFieldDelegate{

    @Owned
    @Selector("alloc")
    public static native AppViewController alloc();

    @Selector("init")
    public native AppViewController init();

    protected AppViewController(Pointer peer) {
        super(peer);
    }

    public SearchAdapter mySearchAdapter;
    private UILabel labelDisplay;

    public UITextField textFieldTitle = null;
    public UITextField textFieldIsdn = null;
    public UITextField textFieldCategory = null;
    public UITextField textFieldAuthor = null;



    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        mySearchAdapter = new SearchAdapter();
        mySearchAdapter.vypis(mySearchAdapter.getAuthor());
        labelDisplay = getDisplayLabel();
        textFieldAuthor = getTextFieldAuthor();
        textFieldAuthor.setDelegate(this);
        textFieldCategory = getTextFieldCategory();
        textFieldCategory.setDelegate(this);
        textFieldTitle = getTextFieldTitle();
        textFieldTitle.setDelegate(this);
        textFieldIsdn = getTextFieldIsdn();
        textFieldIsdn.setDelegate(this);

    }

    @IBAction
    @Selector("buttonSearchPressed:")
    public void buttonSearchPressed(UIButton sender) {
        mySearchAdapter.setTitle(textFieldTitle.text());
        mySearchAdapter.setIsdn(textFieldIsdn.text());
        mySearchAdapter.setCategory(textFieldCategory.text());
        mySearchAdapter.setAuthor(textFieldAuthor.text());
        labelDisplay.setText(mySearchAdapter.getTitle() + " " + mySearchAdapter.getIsdn() + " " + mySearchAdapter.getCategory() + " " + mySearchAdapter.getAuthor());
        mySearchAdapter.vypis(mySearchAdapter.getTitle());
        mySearchAdapter.vypis(mySearchAdapter.getIsdn());
        mySearchAdapter.vypis(mySearchAdapter.getCategory());
        mySearchAdapter.vypis(mySearchAdapter.getAuthor());




        clearField();
    }

    @Selector("clearField:")
    public void clearField() {
        textFieldTitle.setText("");
        textFieldIsdn.setText("");
        textFieldCategory.setText("");
        textFieldAuthor.setText("");
    }

    @Selector("labelDisplay")
    @Property
    @IBOutlet
    public native UILabel getDisplayLabel();

    @Selector("buttonSearch")
    @Property
    @IBOutlet
    public native UIButton getButtonSearch();

    @Selector("textFieldTitle")
    @Property
    @IBOutlet
    public native UITextField getTextFieldTitle();

    @Selector("textFieldIsdn")
    @Property
    @IBOutlet
    public native UITextField getTextFieldIsdn();

    @Selector("textFieldCategory")
    @Property
    @IBOutlet
    public native UITextField getTextFieldCategory();

    @Selector("textFieldAuthor")
    @Property
    @IBOutlet
    public native UITextField getTextFieldAuthor();


}
