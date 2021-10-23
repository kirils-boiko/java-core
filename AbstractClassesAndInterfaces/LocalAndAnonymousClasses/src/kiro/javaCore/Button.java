package kiro.javaCore;

public class Button {
    private String title;
    private IOnClickListener onClickListener;    // does not exist yet
    // note: you provide the local class and set it to the field using setter;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickListener(IOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void onClick() {
        this.onClickListener.onClick(this.title);
    }

    // you need a nested/separate interface so that the class sees at
    //  the declaration of the class which definition is provided locally;
    public interface IOnClickListener {
        public void onClick(String title);
    }
}
