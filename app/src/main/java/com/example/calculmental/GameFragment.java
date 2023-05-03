package com.example.calculmental;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameFragment extends Fragment {

    private TextView tvOperation;
    private TextView tvTimeRemaining;
    private TextView tvLives;
    private EditText etAnswer;
    private Button[] numButtons = new Button[10];
    private Button btnDelete;
    private Button btnSubmit;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        tvOperation = view.findViewById(R.id.tv_operation);
        tvTimeRemaining = view.findViewById(R.id.tv_time_remaining);
        tvLives = view.findViewById(R.id.tv_lives);
        etAnswer = view.findViewById(R.id.et_answer);

        // Initialisez les boutons du clavier numérique
        for (int i = 0; i < 10; i++) {
            int buttonId = getResources().getIdentifier("btn_" + i, "id", getActivity().getPackageName());
            numButtons[i] = view.findViewById(buttonId);
            numButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etAnswer.append(((Button) v).getText().toString());
                }
            });
        }

        // Initialisez le bouton "Supprimer"
        btnDelete = view.findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = etAnswer.getText().toString();
                if (!currentText.isEmpty()) {
                    etAnswer.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });

        // Initialisez le bouton "Confirmer"
        btnSubmit = view.findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // À compléter : vérifiez la réponse et mettez à jour les vies et l'opération
            }
        });

        return view;
    }
}
