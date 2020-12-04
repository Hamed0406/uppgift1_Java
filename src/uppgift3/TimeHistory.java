package uppgift3;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/1/2020
 * This calss contain a model for Time Table Hisotry .
 */
public class TimeHistory {
    private final SimpleStringProperty timeStampData;//Time stamp when stop stopWatch function.
    private final SimpleStringProperty lastTimeData;//Time at timer when stop stopWatch function.

    public TimeHistory(String timeStampData, String lastTimeData) {
        super();
        this.timeStampData = new SimpleStringProperty(timeStampData);
        this.lastTimeData = new SimpleStringProperty(lastTimeData);
    }

    public String getTimeStampData() {
        return timeStampData.get();
    }


    public String getLastTimeData() {
        return lastTimeData.get();
    }

    public void setTimeStampData(String timeStampData) {
        this.timeStampData.set(timeStampData);
    }

    public void setLastTimeData(String lastTimeData) {
        this.lastTimeData.set(lastTimeData);
    }

    @Override
    public String toString() {
        return "TimeHistory{" +
                "timeStampData=" + timeStampData +
                ", lastTimeData=" + lastTimeData +
                '}';
    }
}
