package wat.edu.pl.visitapp.view.authenticated.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.PrescriptionConnection;
import wat.edu.pl.visitapp.database.entity.Prescription;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.PrescriptionCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.adapters.VerticalPrescriptionAdapter;

public class PrescriptionFragment extends Fragment implements PrescriptionCallback {
    private RecyclerView rvVerticalPrescription;
    private List<Prescription> prescriptionList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prescription, container, false);

        getActivity().setTitle(R.string.prescription);

        Bundle args = getArguments();
        User user = (User) args.getSerializable("user");

        rvVerticalPrescription = view.findViewById(R.id.rvVerticalPrescription);

        PrescriptionConnection connection = new PrescriptionConnection(this);
        connection.getListOfPrescription(user.getUserId());

        LinearLayoutManager managerCardView = new LinearLayoutManager(getContext());
        managerCardView.setOrientation(RecyclerView.VERTICAL);
        rvVerticalPrescription.setAdapter(new VerticalPrescriptionAdapter(prescriptionList));
        rvVerticalPrescription.setLayoutManager(managerCardView);

        return view;
    }

    @Override
    public void onSuccessSetPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    @Override
    public void onFailure(String message) {
        ToastUtil.shortToast(getActivity(), message);
        prescriptionList = new LinkedList<>();
    }

    @Override
    public Activity getFragment() {
        return getActivity();
    }
}
