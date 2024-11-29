/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.WorkRequest.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author yuanchanglee
 */
public class WorkQueue {
    ArrayList<WorkRequest> workRequests;

    public WorkQueue() {
        this.workRequests = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequests() {
        return workRequests;
    }
    public void addWorkRequest(WorkRequest request){
        workRequests.add(request);
    }
   
}
