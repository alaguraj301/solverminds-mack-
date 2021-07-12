
package reportGeneration;


public class Data {
                    private String tCID;
                    private String testScenarioDescription;
                    private String testCaseDescription;
                    private String testCaseSteps;
                    private String status;

    /**
     * @return the tCID
     */
    public String gettCID() {
    	
        return tCID;
    }

    /**
     * @param tCID the tCID to set
     */
    public void settCID(String tCID) {
        this.tCID = tCID;
    }

    /**
     * @return the testScenarioDescription
     */
    public String getTestScenarioDescription() {
        return testScenarioDescription;
    }

    /**
     * @param testScenarioDescription the testScenarioDescription to set
     */
    public void setTestScenarioDescription(String testScenarioDescription) {
        this.testScenarioDescription = testScenarioDescription;
    }

    /**
     * @return the testCaseDescription
     */
    public String getTestCaseDescription() {
        return testCaseDescription;
    }

    /**
     * @param testCaseDescription the testCaseDescription to set
     */
    public void setTestCaseDescription(String testCaseDescription) {
        this.testCaseDescription = testCaseDescription;
    }

    /**
     * @return the testCaseSteps
     */
    public String getTestCaseSteps() {
        return testCaseSteps;
    }

    /**
     * @param testCaseSteps the testCaseSteps to set
     */
    public void setTestCaseSteps(String testCaseSteps) {
        this.testCaseSteps = testCaseSteps;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
