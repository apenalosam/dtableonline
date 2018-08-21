package midknight.munch.dtable.util;

import java.util.List;

public class DataTable {

    private int sEcho;
    private int iTotalRecords;
    private int iTotalDisplayRecords;
    private List<Object> aaData;

    /**
     * @return the sEcho
     */
    public int getsEcho() {
        return sEcho;
    }

    /**
     * @param sEcho the sEcho to set
     */
    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }

    /**
     * @return the iTotalRecords
     */
    public int getiTotalRecords() {
        return iTotalRecords;
    }

    /**
     * @param iTotalRecords the iTotalRecords to set
     */
    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    /**
     * @return the iTotalDisplayRecords
     */
    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    /**
     * @param iTotalDisplayRecords the iTotalDisplayRecords to set
     */
    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    /**
     * @return the aaData
     */
    public List<Object> getAaData() {
        return aaData;
    }

    /**
     * @param aaData the aaData to set
     */
    public void setAaData(List<Object> aaData) {
        this.aaData = aaData;
    }

}
