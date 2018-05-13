package Library.ui;

import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.general.ann.RegisterOnStartup;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.IBAction;
import org.moe.natj.objc.ann.IBOutlet;
import org.moe.natj.objc.ann.ObjCClassName;
import org.moe.natj.objc.ann.Property;
import org.moe.natj.objc.ann.Selector;

import apple.NSObject;
import apple.uikit.UIButton;
import apple.uikit.UIColor;
import apple.uikit.UILabel;
import apple.uikit.UIViewController;
import apple.uikit.enums.UIControlEvents;

@org.moe.natj.general.ann.Runtime(ObjCRuntime.class)
@ObjCClassName("AppViewController")
@RegisterOnStartup
public class AppViewController extends UIViewController {

    @Owned
    @Selector("alloc")
    public static native AppViewController alloc();

    @Selector("init")
    public native AppViewController init();

    protected AppViewController(Pointer peer) {
        super(peer);
    }


    private void registerButton(UIButton button) {
        button.addTargetActionForControlEvents(this, new SEL("setButtonActive:"), UIControlEvents
                .TouchDown);
        button.addTargetActionForControlEvents(this, new SEL("setButtonInactive:"), UIControlEvents
                .TouchCancel);
        button.addTargetActionForControlEvents(this, new SEL("setButtonInactive:"), UIControlEvents
                .TouchUpInside);
        button.addTargetActionForControlEvents(this, new SEL("setButtonInactive:"), UIControlEvents
                .TouchUpOutside);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        registerButton(getButtonSearch());
    }

    @IBAction
    @Selector("buttonSearchPressed:")
    public void buttonCPressed(UIButton sender) {
        //co robi stlacenie
    }

    @Selector("buttonSearch")
    @Property
    @IBOutlet
    public native UIButton getButtonSearch();
}
