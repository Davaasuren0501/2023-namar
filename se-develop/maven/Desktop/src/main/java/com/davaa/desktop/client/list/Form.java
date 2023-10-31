package com.davaa.desktop.client.list;

public interface Form {
    void MainView();
    void UpdateView(int id);
    void ChangeList();
    void ActionCreate();
    void ActionRequestNew();
    void ActionRequestUpdate(int id);
    void ActionUpdateAndDelete(String action, int id );
}
