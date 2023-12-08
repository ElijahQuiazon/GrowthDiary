import {useState} from "react";
import DetailsForm from "../forms/DetailsForm.jsx";
import RealTimeForm from "../forms/RealTimeForm.jsx";
import FeedbackForm from "../forms/FeedbackForm.jsx";
import SessionSummaryView from "./SessionSummaryView.jsx";

export default function NewSessionPage() {

    const [currentStep, setCurrentStep] = useState(1);

    const updateStep = () => {
        setCurrentStep(currentStep + 1);
    }

    return (
        <>
            {currentStep === 1 && <DetailsForm stepUpdater={updateStep} newSession={true}/>}
            {currentStep === 2 && <RealTimeForm stepUpdater={updateStep}/>}
            {currentStep === 3 && <FeedbackForm stepUpdater={updateStep}/>}
            {currentStep === 4 && <SessionSummaryView />}
        </>
    )
}