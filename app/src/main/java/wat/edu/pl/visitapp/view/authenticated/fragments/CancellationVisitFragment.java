package wat.edu.pl.visitapp.view.authenticated.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import wat.edu.pl.visitapp.R;

public class CancellationVisitFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        getActivity().setTitle(R.string.cancelVisit);

        return inflater.inflate(R.layout.fragment_cancellation_visit, container, false);
    }
}
