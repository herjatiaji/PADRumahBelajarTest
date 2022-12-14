// Generated by view binder compiler. Do not edit!
package com.pad1.padrumahbelajar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.pad1.padrumahbelajar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemQuestionBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cv;

  @NonNull
  public final RadioButton rbA;

  @NonNull
  public final RadioButton rbB;

  @NonNull
  public final RadioButton rbC;

  @NonNull
  public final RadioButton rbD;

  @NonNull
  public final RadioButton rbE;

  @NonNull
  public final RadioGroup rg;

  @NonNull
  public final TextView tvQuestion;

  private ItemQuestionBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cv,
      @NonNull RadioButton rbA, @NonNull RadioButton rbB, @NonNull RadioButton rbC,
      @NonNull RadioButton rbD, @NonNull RadioButton rbE, @NonNull RadioGroup rg,
      @NonNull TextView tvQuestion) {
    this.rootView = rootView;
    this.cv = cv;
    this.rbA = rbA;
    this.rbB = rbB;
    this.rbC = rbC;
    this.rbD = rbD;
    this.rbE = rbE;
    this.rg = rg;
    this.tvQuestion = tvQuestion;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemQuestionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemQuestionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_question, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemQuestionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cv;
      CardView cv = ViewBindings.findChildViewById(rootView, id);
      if (cv == null) {
        break missingId;
      }

      id = R.id.rbA;
      RadioButton rbA = ViewBindings.findChildViewById(rootView, id);
      if (rbA == null) {
        break missingId;
      }

      id = R.id.rbB;
      RadioButton rbB = ViewBindings.findChildViewById(rootView, id);
      if (rbB == null) {
        break missingId;
      }

      id = R.id.rbC;
      RadioButton rbC = ViewBindings.findChildViewById(rootView, id);
      if (rbC == null) {
        break missingId;
      }

      id = R.id.rbD;
      RadioButton rbD = ViewBindings.findChildViewById(rootView, id);
      if (rbD == null) {
        break missingId;
      }

      id = R.id.rbE;
      RadioButton rbE = ViewBindings.findChildViewById(rootView, id);
      if (rbE == null) {
        break missingId;
      }

      id = R.id.rg;
      RadioGroup rg = ViewBindings.findChildViewById(rootView, id);
      if (rg == null) {
        break missingId;
      }

      id = R.id.tvQuestion;
      TextView tvQuestion = ViewBindings.findChildViewById(rootView, id);
      if (tvQuestion == null) {
        break missingId;
      }

      return new ItemQuestionBinding((ConstraintLayout) rootView, cv, rbA, rbB, rbC, rbD, rbE, rg,
          tvQuestion);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}