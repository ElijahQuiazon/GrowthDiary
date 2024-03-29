import {Route, Routes} from 'react-router-dom'
import NotFoundPage from "../components/NotFoundPage.jsx";
import HomePage from "../features/home/homepage.jsx";
import BeforeSessionView from "../features/sessiontracker/views/BeforeSessionView.jsx";
import NewSessionPage from "../features/sessiontracker/views/NewSessionPage.jsx";
import OldSessionPage from "../features/sessiontracker/views/OldSessionPage.jsx";
import HistoryView from "../features/sessionhistory/HistoryView.jsx";
import AnalyticsView from "../features/sessionanalytics/AnalyticsView.jsx";
export default function ApplicationRoutes() {

    return (
        <Routes>
            <Route path="/" element={<HomePage />}></Route>
            <Route path="/session" element={<BeforeSessionView />}></Route>
            <Route path="/session/new" element={<NewSessionPage />}></Route>
            <Route path="/session/old" element={<OldSessionPage />}></Route>
            <Route path="/history" element={<HistoryView />}></Route>
            <Route path="/analytics" element={ <AnalyticsView />}></Route>
            <Route path="*" element={<NotFoundPage />}></Route>
        </Routes>
    )
}