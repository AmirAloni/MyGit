package mygit.service.Logic;

import java.util.ArrayList;

public class OpenAndConflict {
    private ArrayList<Conflict> conflictList;
    private ArrayList<OpenChange> openChangesList;

    public OpenAndConflict(ArrayList<Conflict> conflictList, ArrayList<OpenChange> openChangesList) {
        this.conflictList = conflictList;
        this.openChangesList = openChangesList;
    }

    public ArrayList<Conflict> getConflictList() {
        return conflictList;
    }

    public ArrayList<OpenChange> getOpenChangesList() {
        return openChangesList;
    }
}


