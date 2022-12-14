// Generated by view binder compiler. Do not edit!
package com.pad1.padrumahbelajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.pad1.padrumahbelajar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemLabelQuizBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView tvMapel;

  @NonNull
  public final TextView tvQuiz;

  private ItemLabelQuizBinding(@NonNull CardView rootView, @NonNull TextView tvMapel,
      @NonNull TextView tvQuiz) {
    this.rootView = rootView;
    this.tvMapel = tvMapel;
    this.tvQuiz = tvQuiz;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemLabelQuizBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemLabelQuizBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_label_quiz, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemLabelQuizBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tvMapel;
      TextView tvMapel = ViewBindings.findChildViewById(rootView, id);
      if (tvMapel == null) {
        break missingId;
      }

      id = R.id.tvQuiz;
      TextView tvQuiz = ViewBindings.findChildViewById(rootView, id);
      if (tvQuiz == null) {
        break missingId;
      }

      return new ItemLabelQuizBinding((CardView) rootView, tvMapel, tvQuiz);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
