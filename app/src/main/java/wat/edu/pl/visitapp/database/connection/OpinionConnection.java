package wat.edu.pl.visitapp.database.connection;

import wat.edu.pl.visitapp.interfaces.callbacks.OpinionCallback;

public class OpinionConnection {
    private OpinionCallback callback;

    public OpinionConnection(OpinionCallback callback) {
        this.callback = callback;
    }

    public void addOpinion(int visitId, int userId, int numberOfStars)
    {
        callback.onSuccessAddOpinion("Opinia została dodana");
    }
}
