package ai.quantumsense.tgmonitor.backend;

public class InteractorImplFactory implements InteractorFactory {
    @Override
    public Interactor getInteractor() {
        Interactor interactor = InteractorImpl.get();
        if (interactor == null)
            throw new RuntimeException("Attempting to get instance of " + Interactor.class.getSimpleName() + ", but has not yet been initialized");
        return interactor;
    }
}
