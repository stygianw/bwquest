package ua.stygianw.quest.cells;

/**
 * Created by User on 25.09.2016.
 */
public class QuestCell {

    private QuestCell forward;
    private QuestCell left;
    private QuestCell right;
    private QuestCell back;

    private String descriptionOfThis;
    private String descriptionOfLeft;
    private String descriptionOfRight;

    QuestCell(QuestCellBuilder builder) {
        this.forward = builder.forward;
        this.left = builder.left;
        this.right = builder.right;
        this.descriptionOfThis = builder.descriptionOfThis;
        this.descriptionOfLeft = builder.descriptionOfLeft;
        this.descriptionOfRight = builder.descriptionOfRight;
        this.back = builder.back;
    }

    public QuestCell getForward() {
        return forward;
    }

    public QuestCell getLeft() {
        return left;
    }

    public QuestCell getRight() {
        return right;
    }

    public QuestCell getBack() {
        return back;
    }

    public String getDescriptionOfThis() {
        return descriptionOfThis;
    }

    public String getDescriptionOfLeft() {
        return descriptionOfLeft;
    }

    public String getDescriptionOfRight() {
        return descriptionOfRight;
    }

    public static class QuestCellBuilder {

        private QuestCell forward;
        private QuestCell left;
        private QuestCell right;
        private QuestCell back;

        private String descriptionOfThis;
        private String descriptionOfLeft;
        private String descriptionOfRight;


        public QuestCellBuilder setForward(QuestCell forward) {
            this.forward = forward;
            return this;
        }

        public QuestCellBuilder setleft(QuestCell left) {
            this.left = left;
            return this;
        }

        public QuestCellBuilder setRight(QuestCell right) {
            this.right = right;
            return this;
        }

        public QuestCellBuilder setBack(QuestCell back) {
            this.back = back;
            return this;
        }
        
        public QuestCellBuilder setDescriptionOfThis(String descriptionOfThis) {
            this.descriptionOfThis = descriptionOfThis;
            return this;
        }

        public QuestCellBuilder setDescriptionOfLeft(String descriptionOfLeft) {
            this.descriptionOfLeft = descriptionOfLeft;
            return this;
        }

        public QuestCellBuilder setdescriptionOfRight(String descriptionOfRight) {
            this.descriptionOfRight = descriptionOfRight;
            return this;
        }

        public QuestCell toCell() {
            return new QuestCell(this);
        }

    }

}
