package com.dreamer.myweather2.ui.weather.future.list;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class FutureListWeatherFragmentDirections {
  @NonNull
  public static ActionDetail actionDetail(@NonNull String dateString) {
    return new ActionDetail(dateString);
  }

  public static class ActionDetail implements NavDirections {
    @NonNull
    private String dateString;

    public ActionDetail(@NonNull String dateString) {
      this.dateString = dateString;
      if (this.dateString == null) {
        throw new IllegalArgumentException("Argument \"dateString\" is marked as non-null but was passed a null value.");
      }
    }

    @NonNull
    public ActionDetail setDateString(@NonNull String dateString) {
      if (dateString == null) {
        throw new IllegalArgumentException("Argument \"dateString\" is marked as non-null but was passed a null value.");
      }
      this.dateString = dateString;
      return this;
    }

    @NonNull
    public Bundle getArguments() {
      Bundle __outBundle = new Bundle();
      __outBundle.putString("dateString", this.dateString);
      return __outBundle;
    }

    public int getActionId() {
      return com.dreamer.myweather2.R.id.actionDetail;
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionDetail that = (ActionDetail) object;
      if (dateString != null ? !dateString.equals(that.dateString) : that.dateString != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = super.hashCode();
      result = 31 * result + (dateString != null ? dateString.hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionDetail(actionId=" + getActionId() + "){"
          + "dateString=" + dateString
          + "}";
    }
  }
}
