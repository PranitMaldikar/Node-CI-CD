# NodeJS DevOps Application

This NodeJS web application integrates sophisticated user features such as registration/login, camp setups, image uploads via Cloudinary, and viewing camps on an interactive Mapbox cluster map. It is developed with a focus on robust DevOps practices to streamline development and deployment processes.

## Architecture

![](./images/homearchitecture.png)

## Technology Stack

- **Node.js**: Serves as the runtime environment for the server-side logic.
- **MongoDB Atlas**: Database service used for storing all application data.
- **Docker**: Used for containerizing the application and ensuring consistent environments across different stages.
- **Jenkins**: Automates the continuous integration and deployment pipelines.
- **AWS (Amazon Web Services)**: Provides cloud infrastructure for hosting services and managing resources, including the use of Elastic Kubernetes Service (EKS).
- **Kubernetes**: Manages container orchestration to ensure the application scales and deploys efficiently across the cloud environment.
- **SonarQube**: Assists in continuous inspection of code quality.
- **Trivy**: Security scanning tool that detects vulnerabilities in the application and Docker images.
- **Cloudinary**: Manages cloud-based image storage and manipulation.
- **Mapbox**: Provides interactive maps where users can view camp locations.
- **Express**: Web application framework for Node.js.

## DevOps Configuration and Deployment

### DevOps Tools and Pipelines

The project utilizes Jenkins for orchestrating the CI/CD workflows, Docker for application containerization, SonarQube for code quality analysis, and Trivy for security assessments. The deployment process is structured into two main pipelines:

- **Dev Deployment**: Manages the integration and testing phases, including security scans and Docker image preparations.
- **Production Deployment**: Extends the Dev pipeline to deploy the application on AWS Elastic Kubernetes Service (EKS) using an automated Jenkins pipeline.

### AWS EKS Setup

The application is deployed using AWS EKS, ensuring scalable and secure management of Kubernetes resources:

- **EKS Cluster Configuration**:
  - The cluster setup is initiated without a default node group, allowing custom configuration.
  - Integration with IAM OIDC provider enhances security and management of permissions within AWS services.
- **AWS CLI and kubectl Configuration**:
  - Tools such as AWS CLI and kubectl are configured to interact with AWS services and manage Kubernetes resources effectively.

## Security and Compliance

Security is a cornerstone of the project's DevOps strategy. It integrates Trivy for comprehensive vulnerability scanning and SonarQube for ongoing code quality checks, ensuring that the application adheres to high security and quality standards.

## Setup Instructions

To deploy this application, you will need to configure several tools and accounts:

1. Create accounts on Cloudinary, Mapbox, and MongoDB Atlas.
2. Configure environment variables in a `.env` file located in your project directory as follows:

   ```sh
   CLOUDINARY_CLOUD_NAME=[Your Cloudinary Cloud Name]
   CLOUDINARY_KEY=[Your Cloudinary Key]
   CLOUDINARY_SECRET=[Your Cloudinary Secret]
   MAPBOX_TOKEN=[Your Mapbox Token]
   DB_URL=[Your MongoDB Atlas Connection URL]
   SECRET=[Your Chosen Secret Key]
   ```

3. To start the application, run the following command:

   ```sh
   docker compose up
   ```

This project was built by following this [YouTube video](https://www.youtube.com/@devopsshack) and this [GitHub repository](https://github.com/jaiswaladi246/3-Tier-Full-Stack).

## Application Screenshots

![](./images/home.jpg)
![](./images/campgrounds.jpg)
![](./images/register.jpg)
