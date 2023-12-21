package DSA_Final_Project;

import java.util.ArrayList;
import java.util.List;

public class Med_Con_Config {
    private static List<Medical_Condition> med_Con_List = new ArrayList<>();

    public static List<Medical_Condition> generateMedConfig() {
        med_Con_List.add(new Medical_Condition("Sudden cardiac arrest", "cardiac arrest",100, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("hemorrhage", "Severe bleeding",99, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Severe Head Trauma", "Severe Head Trauma", 98, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Severe Chest Trauma", "Severe Chest Trauma", 97, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Severe burns", "burns",96, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Sepsis", "Septic Shock",95, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Acute myocardial infarction", "heart attack", 94, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Cerebrovascular Accident", "Stroke",93, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Spinal Cord Injuries", "Spinal Cord Injuries", 92, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Pulmonary Embolism", "Blood clots in the lungs",91, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("seizures", "seizures",90, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("anaphylaxis", "Severe allergic reactions",89, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("severe pneumonia", "severe pneumonia",88, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Kidney stones", "Kidney stones",87, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Crush Injuries", "Crush Injuries", 86, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Asthma", "Severe Asthma Attack",85, Triage.EMERGENCY));
        med_Con_List.add(new Medical_Condition("Overdose", "Overdose",84, Triage.EMERGENCY));

        med_Con_List.add(new Medical_Condition("Bacterial Endocarditis", "Bacterial Endocarditis",80, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("Pulmonary Edema", "Pulmonary Edema",79, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("Acute Bronchitis", "Acute Bronchitis",78, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("Deep Abscesses", "Deep Abscesses",77, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("pneumonia", "pneumonia",76, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("appendicitis", "Severe abdominal pain",75, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("Pyelonephritis", "Pyelonephritis",74, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("Osteomyelitiss", "Osteomyelitis",73, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("DVT", "Deep vein thrombosis",72, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("Abdominal Trauma", "Abdominal Trauma",71, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("pancreatitis", "pancreatitis",70, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("Fractures", "dislocations",69, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("Intra-abdominal Infections", "Intra-abdominal Infections", 78, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("COPD", "Chronic Obstructive Pulmonary Disease",77, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("Facial Trauma", "Facial Trauma",76, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("dehydration", "dehydration",75, Triage.URGENT));
        med_Con_List.add(new Medical_Condition("Kidney stones", "Kidney stones",74, Triage.URGENT));

        med_Con_List.add(new Medical_Condition("allergic reactions", "allergies",60, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("Minor Head Injuries", "Minor Head Injuries",59, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("wounds", "cuts",58, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("fever", "high persistent fever",57, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("Cellulitis", "Cellulitis",56, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("UTI", "Urinary Tract Infections",55, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("hypertension", "hypertension",100, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("Skin Infections", "Skin Infections",54, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("hypertension", "hypertension",53, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("diabetes", "diabetes",52, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("headache", "headache",51, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("rashes", "rashes",50, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("depression", "depression",49, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("Sprains", "Sprains",48, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("Minor Soft Tissue Injuries", "Minor Soft Tissue Injuries",47, Triage.NONURGENT));
        med_Con_List.add(new Medical_Condition("cold", "flu",46, Triage.NONURGENT));
        return med_Con_List;
    }

}
