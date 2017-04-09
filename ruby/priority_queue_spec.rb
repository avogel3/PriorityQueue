require_relative 'priority_queue'

RSpec.describe PriorityQueue do
  it { should respond_to(:queue) }
  it { should respond_to(:size) }

end
