package mygit.service.Logic.Objects;

public class BranchDates {
    String BranchName;
    String BranchLastCommitDate;

    public BranchDates(String branchName, String branchLastCommitDate) {
        BranchName = branchName;
        BranchLastCommitDate = branchLastCommitDate;
    }

    public String getBranchName() {
        return BranchName;
    }

    public String getBranchLastCommitDate() {
        return BranchLastCommitDate;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public void setBranchLastCommitDate(String branchLastCommitDate) {
        BranchLastCommitDate = branchLastCommitDate;
    }
}
