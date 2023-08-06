package com.virtusa.notificationservice.response;


public class PatientDetails {

private int patientId;
private String username;
private String password;
private String fullName;
private long phoneNo;
private String email;
private String address;
private int healthProviderID;


public int getHealthProviderID() {
return healthProviderID;
}

public void setHealthProviderID(int healthProviderID) {
this.healthProviderID = healthProviderID;
}


public int getPatientId() {
return patientId;
}

public void setPatientId(int patientId) {
this.patientId = patientId;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getFullName() {
return fullName;
}

public void setFullName(String fullName) {
this.fullName = fullName;
}

public long getPhoneNo() {
return phoneNo;
}

public void setPhoneNo(long phoneNo) {
this.phoneNo = phoneNo;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

@Override
public String toString() {
return "PatientDetailsResponse{" +
"patientId=" + patientId +
", username='" + username + '\'' +
", password='" + password + '\'' +
", fullName='" + fullName + '\'' +
", phoneNo=" + phoneNo +
", email='" + email + '\'' +
", address='" + address + '\'' +
'}';
}
}
