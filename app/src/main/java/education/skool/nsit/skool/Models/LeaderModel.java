package education.skool.nsit.skool.Models;

/**
 * Created by ashu on 11/2/18.
 */


public class LeaderModel {
    public String leaderBoardName;
    public String leaderBoardSCore;
    public int paytmImage;

    public LeaderModel(String leaderBoardName, String leaderBoardSCore, int paytmImage) {
        this.leaderBoardSCore = leaderBoardSCore;
        this.leaderBoardName = leaderBoardName;
        this.paytmImage = paytmImage;
    }


}

