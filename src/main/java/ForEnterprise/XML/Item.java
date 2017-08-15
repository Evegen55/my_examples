package ForEnterprise.XML;

/**
 * @author (created on 8/15/2017).
 */
public class Item {
    private String date;
    private String mode;
    private String unit;
    private String current;
    private String interactive;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getInteractive() {
        return interactive;
    }

    public void setInteractive(String interactive) {
        this.interactive = interactive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (getDate() != null ? !getDate().equals(item.getDate()) : item.getDate() != null) return false;
        if (getMode() != null ? !getMode().equals(item.getMode()) : item.getMode() != null) return false;
        if (getUnit() != null ? !getUnit().equals(item.getUnit()) : item.getUnit() != null) return false;
        if (getCurrent() != null ? !getCurrent().equals(item.getCurrent()) : item.getCurrent() != null) return false;
        return getInteractive() != null ? getInteractive().equals(item.getInteractive()) : item.getInteractive() == null;
    }

    @Override
    public int hashCode() {
        int result = getDate() != null ? getDate().hashCode() : 0;
        result = 31 * result + (getMode() != null ? getMode().hashCode() : 0);
        result = 31 * result + (getUnit() != null ? getUnit().hashCode() : 0);
        result = 31 * result + (getCurrent() != null ? getCurrent().hashCode() : 0);
        result = 31 * result + (getInteractive() != null ? getInteractive().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("date='").append(date).append('\'');
        sb.append(", mode='").append(mode).append('\'');
        sb.append(", unit='").append(unit).append('\'');
        sb.append(", current='").append(current).append('\'');
        sb.append(", interactive='").append(interactive).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
