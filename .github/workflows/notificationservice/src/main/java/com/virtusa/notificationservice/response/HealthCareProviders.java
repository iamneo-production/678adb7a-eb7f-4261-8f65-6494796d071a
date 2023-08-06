package com.virtusa.notificationservice.response;

public class HealthCareProviders {


private int healthCareID;
private String email;
private long phoneNo;

public int getHealthCareID() {
return healthCareID;
}

public void setHealthCareID(int healthCareID) {
this.healthCareID = healthCareID;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public long getPhoneNo() {
return phoneNo;
}

public void setPhoneNo(long phoneNo) {
this.phoneNo = phoneNo;
}

@Override
public String toString() {
return "HealthCareProviders{" +
"healthCareID=" + healthCareID +
", email='" + email + '\'' +
", phoneNo=" + phoneNo +
'}';
}
}